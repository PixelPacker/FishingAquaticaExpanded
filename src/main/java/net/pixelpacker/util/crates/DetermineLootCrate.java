package net.pixelpacker.util.crates;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.blocks.crates.util.CrateTables;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;
import net.pixelpacker.registers.TagReg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class DetermineLootCrate {
    public static ItemStack chooseCrate(ItemStack usedItem){
        if(usedItem.isIn(TagReg.T1_LOOT_CRATE_RODS)){
            ItemStack chosenCrate = new ItemStack(getCrate(CrateTables.tierOneCrates));
            if(FishingAquaticaExpanded.DebugMode){
                FishingAquaticaExpanded.LOGGER.info("Giving player: " + chosenCrate.getName());
            }
            return chosenCrate;
        }
        else{
            FishingAquaticaExpanded.LOGGER.info("Something has gone horribly wrong and you probably should have gotten a crate.");
            return new ItemStack(Items.AIR);
        }
    }

    private static Block getCrate(List<Block> lootTable){
        if(FishingAquaticaExpanded.DebugMode){
            FishingAquaticaExpanded.LOGGER.info("Loot Size: " + lootTable.size());
        }
        int rand = FishingAquaticaExpanded.rand.nextInt(lootTable.size());
        return lootTable.get(rand);
    }
}
