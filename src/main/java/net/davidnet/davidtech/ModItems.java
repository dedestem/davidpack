package net.davidnet.davidtech;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    // Items
    public static final Item OBSIDIANDUST = new Item(new Item.Settings());
    public static final Item MORTAR = new Item(new Item.Settings()
            .recipeRemainder(Items.FLINT)
            .maxCount(1));

    public static void register(Item item, String id) {
        // Use the Identifier.of() method for creating the identifier
        Identifier itemID = Identifier.of(Davidtech.MOD_ID, id);

        // Register and return the item directly
        Registry.register(Registries.ITEM, itemID, item);

        Davidtech.LOGGER.info("Registered item: {} with ID: {}", item.getName().getString(), itemID.toString());
    }

    public static void registerAll() {
        // Register your items
        register(OBSIDIANDUST, "obsidiandust");
        register(MORTAR, "mortar");
    }

    // Method to handle item group modification
    public static void registerItemGroupEntries() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
            itemGroup.add(OBSIDIANDUST);
            itemGroup.add(MORTAR);
        });
    }
}