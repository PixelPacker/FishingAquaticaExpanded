package net.pixelpacker.registers;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.crates.blocks.BlazingCrateBlock;
import net.pixelpacker.crates.blocks.MinerCrateBlock;
import net.pixelpacker.crates.blocks.MonsterCrateBlock;
import net.pixelpacker.crates.blocks.MusicCrateBlock;

public class BlockReg {
    public static final Block MINER_CRATE = new MinerCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MONSTER_CRATE = new MonsterCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BLAZING_CRATE = new BlazingCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MUSIC_CRATE = new MusicCrateBlock(FabricBlockSettings.create().strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public void registerBlocks(){
        register("miner_crate", MINER_CRATE);
        register("monster_crate", MONSTER_CRATE);
        register("blazing_crate", BLAZING_CRATE);
        register("music_crate", MUSIC_CRATE);
    }

    private void register(String blockName, Block block){
        Registry.register(Registries.BLOCK, new Identifier(FishingAquaticaExpanded.MODID, blockName), block);
        Registry.register(Registries.ITEM, new Identifier(FishingAquaticaExpanded.MODID, blockName), new BlockItem(block, new FabricItemSettings()));
    }
}
