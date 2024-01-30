package net.pixelpacker.util.crates;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.registers.BlockReg;

import java.util.ArrayList;
import java.util.Collections;

public class DetermineLootCrate {
    public static ArrayList<Block> tierOneCrates = new ArrayList<Block>();

    public void registerCrates(){
        Collections.addAll(tierOneCrates, BlockReg.BASIC_CRATE);
    }

    public static ItemStack chooseCrate(ItemStack usedItem){
        tierOneCrates.add(BlockReg.BASIC_CRATE);
        int randomCrate = FishingAquaticaExpanded.rand.nextInt(tierOneCrates.size());
        return new ItemStack(tierOneCrates.get(randomCrate));
    }
}
