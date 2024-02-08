package net.pixelpacker.blocks.crates.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.blocks.crates.util.interfaces.CrateSound;

public class BasicCrateSound implements CrateSound {
    /**
     * <h3>Spawns sound effects at target location</h3>
     * <p>Can be overwritten to allow for different sound effects for different crates</p>
     */
    public void playSound(ServerWorld world, BlockPos pos){
        play(world, pos, SoundEvents.ENTITY_GENERIC_EXPLODE);
        play(world, pos, SoundEvents.ENTITY_PLAYER_LEVELUP);
    }

    public void play(ServerWorld world, BlockPos pos, SoundEvent soundEvents){
        float pitch = randomizePitchAndVol(0);
        float vol = randomizePitchAndVol(0);
        world.playSound(null, pos, soundEvents, SoundCategory.BLOCKS, pitch, vol);
    }

    public void play(ServerWorld world, BlockPos pos, SoundEvent soundEvents, float pitchMod){
        float pitch = randomizePitchAndVol(pitchMod);
        float vol = randomizePitchAndVol(0);
        world.playSound(null, pos, soundEvents, SoundCategory.BLOCKS, pitch, vol);
    }

    public float randomizePitchAndVol(float pitchMod){
        return FishingAquaticaExpanded.rand.nextFloat(0.75f, 1f) + pitchMod;
    }
}
