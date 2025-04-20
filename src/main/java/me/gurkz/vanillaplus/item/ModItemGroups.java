package me.gurkz.vanillaplus.item;

import me.gurkz.vanillaplus.VanillaPlus;
import me.gurkz.vanillaplus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VANILLA_PLUS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(VanillaPlus.MOD_ID, "vanilla_plus_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BACKERIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.vanillaplus.vanilla_plus_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.INCOMPLETE_BACKERIUM_NUGGET);
                        entries.add(ModItems.BACKERIUM_NUGGET);
                        entries.add(ModBlocks.BACKERIUM_BLOCK);
                    }))
                    .build()
    );

    public static void registerItemGroups() {
        VanillaPlus.LOGGER.info("registering item groups for " + VanillaPlus.MOD_ID);
    }
}
