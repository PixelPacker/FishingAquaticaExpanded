package net.pixelpacker.registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.items.fishingrods.LootCrateFishingRod;

public class ItemReg {

    public static final LootCrateFishingRod LOOT_CRATE_FISHING_ROD = new LootCrateFishingRod(new FabricItemSettings());

    public void registerItems(){
        register("loot_crate_fishing_rod", LOOT_CRATE_FISHING_ROD);
    }

    private void register(String itemName, Item item){
        Registry.register(Registries.ITEM, new Identifier(FishingAquaticaExpanded.MODID, itemName), item);
    }
}
