package me.gurkz.vanillaplus.mixin;

import me.gurkz.vanillaplus.VanillaPlus;
import net.minecraft.world.Heightmap;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Heightmap.class)
public class HeightmapLogShutterUpperMixin {
    @Inject(
            method = "setTo",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;)V",
                    remap = false
            ),
            cancellable = true
    )
    private void suppressHeightmapWarning(Chunk chunk, Heightmap.Type type, long[] values, CallbackInfo ci) {
        if (VanillaPlus.CONFIG.disableHeightmapSizeMismatchLog()) {
            ci.cancel();
        }
    }
}
