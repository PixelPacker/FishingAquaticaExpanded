package net.pixelpacker.registers;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.blocks.crates.BasicCrate;
import net.minecraft.block.Block;

public class BlockReg {
    public static final Block BASIC_CRATE = new BasicCrate(FabricBlockSettings.create().strength(2.0f));
    public static BlockItem BASIC_CRATE_ITEM;
    public void registerBlocks(){
        register("basic_crate", BASIC_CRATE, BASIC_CRATE_ITEM);
    }

    private void register(String blockName, Block block, BlockItem blockItem){
        Registry.register(Registries.BLOCK, new Identifier(FishingAquaticaExpanded.MODID, blockName), block);
        blockItem = Registry.register(Registries.ITEM, new Identifier(FishingAquaticaExpanded.MODID, blockName), new BlockItem(block, new FabricItemSettings()));
    }
}
