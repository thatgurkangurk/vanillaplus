package me.gurkz.vanillaplus.mixin;

/*
    this is essentially a port of the "Silence Mobs" data pack by Vanilla Tweaks
    read more in the credits.txt file
 */

import me.gurkz.vanillaplus.VanillaPlus;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.NameTagItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NameTagItem.class)
public abstract class NameTagItemMixin {
    @Inject(method = "useOnEntity", at = @At("HEAD"), cancellable = true)
    private void silenceEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        Text text = stack.get(DataComponentTypes.CUSTOM_NAME);
        if (text == null || entity instanceof PlayerEntity || user.getWorld().isClient || !entity.isAlive()) {
            return;
        }

        if (!VanillaPlus.CONFIG.silenceMobs.validNames().contains(text.getString().toLowerCase())) {
            return;
        }

        entity.setSilent(true);
        entity.setCustomName(Text.literal("silenced"));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 3 * 20, 0, false, false));

        ServerWorld world = (ServerWorld) user.getWorld();
        Vec3d pos = entity.getPos();
        world.playSound(
                null,
                pos.x, pos.y, pos.z,
                SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE,
                SoundCategory.AMBIENT,
                0.8f,
                2.0f
        );

        if (entity instanceof MobEntity mobEntity) {
            mobEntity.setPersistent();
        }

        stack.decrement(1);
        cir.setReturnValue(ActionResult.success(user.getWorld().isClient));
    }
}
