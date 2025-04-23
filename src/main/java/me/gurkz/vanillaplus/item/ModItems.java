package me.gurkz.vanillaplus.item;

import me.gurkz.vanillaplus.VanillaPlus;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BACKERIUM_NUGGET = registerItem("backerium_nugget", new Item(new Item.Settings()));
    public static final Item INCOMPLETE_BACKERIUM_NUGGET = registerItem("incomplete_backerium_nugget", new Item(new Item.Settings()));
    public static final Item SUPERHEATED_BACKERIUM_NUGGET = registerItem("superheated_backerium_nugget", new Item(new Item.Settings()));

    public static final Item BACKERIUM_STICK = registerItem("backerium_stick", new Item(new Item.Settings()));
    public static final Item SHORT_BACKERIUM_STICK = registerItem("short_backerium_stick", new Item(new Item.Settings()));

    public static final Item BACKERIUM_DAGGER = registerItem("backerium_dagger", new SwordItem(ModToolMaterials.BACKERIUM, new Item.Settings()
            .attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.BACKERIUM, 3, -2.4f)
            )));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VanillaPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaPlus.LOGGER.info("registering mod items for " + VanillaPlus.MOD_ID);
    }
}
