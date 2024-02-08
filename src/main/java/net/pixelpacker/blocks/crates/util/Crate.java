package net.pixelpacker.blocks.crates.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.blocks.crates.util.interfaces.CrateParticle;
import net.pixelpacker.blocks.crates.util.interfaces.CrateSound;
import org.jetbrains.annotations.Nullable;

public class Crate extends Block {
    public CrateSound crateSound;
    public CrateParticle crateParticle;

    public Crate(Settings settings) {
        super(settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005F);
        if(world instanceof ServerWorld sWorld){
            try{
                playCrateSound(sWorld, pos);
                spawnCrateParticles(sWorld, pos);
            }catch(Exception e){
                FishingAquaticaExpanded.LOGGER.info("Failed to spawn/play crate effects.");
                FishingAquaticaExpanded.LOGGER.info(e.toString());
            }
        }
        dropStacks(state, world, pos, blockEntity, player, tool);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        setCrateSound();
        setCrateParticle();
    }

    public void spawnCrateParticles(ServerWorld world, BlockPos pos){
        crateParticle.spawnParticles(world, pos);
    }

    public void playCrateSound(ServerWorld world, BlockPos pos){
        crateSound.playSound(world, pos);
    }


    /**
     *<h3>Sets the CrateSound class for the crate.</h3>
     *<p>Overwrite this to change the sounds of the crate</p>
     */
    public void setCrateSound(){ crateSound = new BasicCrateSound(); }

    /**
     *<h3>Sets the CrateParticles class for the crate.</h3>
     *<p>Overwrite this to change the particles of the crate</p>
     */
    public void setCrateParticle(){ crateParticle = new BasicCrateParticle(); }
}
