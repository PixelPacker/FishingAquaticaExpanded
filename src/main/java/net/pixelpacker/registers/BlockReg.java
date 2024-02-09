package net.pixelpacker.registers;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.crates.blocks.BasicCrateBlock;
import net.minecraft.block.Block;
import net.pixelpacker.crates.blocks.SpicyCrateBlock;

public class BlockReg {
    public static final Block BASIC_CRATE = new BasicCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPICY_CRATE = new SpicyCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public void registerBlocks(){
        register("basic_crate", BASIC_CRATE);
        register("spicy_crate", SPICY_CRATE);
    }

    private void register(String blockName, Block block){
        Registry.register(Registries.BLOCK, new Identifier(FishingAquaticaExpanded.MODID, blockName), block);
        Registry.register(Registries.ITEM, new Identifier(FishingAquaticaExpanded.MODID, blockName), new BlockItem(block, new FabricItemSettings()));
    }
}
