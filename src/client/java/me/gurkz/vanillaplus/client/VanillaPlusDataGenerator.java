package me.gurkz.vanillaplus.client;

import me.gurkz.vanillaplus.client.datagen.ModBlockTagProvider;
import me.gurkz.vanillaplus.client.datagen.ModLootTableProvider;
import me.gurkz.vanillaplus.client.datagen.ModModelProvider;
import me.gurkz.vanillaplus.client.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class VanillaPlusDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
