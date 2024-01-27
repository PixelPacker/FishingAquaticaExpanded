package net.pixelpacker.blocks.crates.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

public class Crate extends Block {

    public CrateSound crateSound = new CrateSound();
    public CrateParticles crateParticles = new CrateParticles();

    public Crate(Settings settings) {
        super(settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005F);
        if(world instanceof ServerWorld sWorld){
            playCrateSound(sWorld, pos);
            spawnCrateParticles(sWorld, pos);
        }
        dropStacks(state, world, pos, blockEntity, player, tool);
    }

    public void spawnCrateParticles(ServerWorld world, BlockPos pos){
        crateParticles.spawnParticles(world, pos);
    }

    public void playCrateSound(ServerWorld world, BlockPos pos){
        crateSound.playSound(world, pos);
    }
}
