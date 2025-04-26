package me.gurkz.vanillaplus;

import me.gurkz.vanillaplus.block.ModBlocks;
import me.gurkz.vanillaplus.config.VanillaPlusConfig;
import me.gurkz.vanillaplus.item.ModItemGroups;
import me.gurkz.vanillaplus.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaPlus implements ModInitializer {
    public static final String MOD_ID = "vanillaplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final VanillaPlusConfig CONFIG = VanillaPlusConfig.createAndLoad();

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
