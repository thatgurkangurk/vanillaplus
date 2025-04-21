package me.gurkz.vanillaplus.client.datagen;

import me.gurkz.vanillaplus.block.ModBlocks;
import me.gurkz.vanillaplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BACKERIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BACKERIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.INCOMPLETE_BACKERIUM_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.BACKERIUM_WAND, Models.HANDHELD);
    }
}
