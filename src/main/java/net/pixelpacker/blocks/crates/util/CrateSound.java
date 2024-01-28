package net.pixelpacker.blocks.crates.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pixelpacker.FishingAquaticaExpanded;

public class CrateSound {
    /**
     * <h3>Spawns sound effects at target location</h3>
     * <p>Can be overwritten to allow for different sound effects for different crates</p>
     */
    public void playSound(ServerWorld world, BlockPos pos){
        pSound(world, pos, SoundEvents.ENTITY_GENERIC_EXPLODE);
        pSound(world, pos, SoundEvents.ENTITY_PLAYER_LEVELUP);
    }

    private void pSound(ServerWorld world, BlockPos pos, SoundEvent soundEvents){
        float pitch = randomizePitchAndVol();
        float vol = randomizePitchAndVol();
        world.playSound(null, pos, soundEvents, SoundCategory.BLOCKS, pitch, vol);
    }

    public float randomizePitchAndVol(){
        return FishingAquaticaExpanded.rand.nextFloat(0.5f, 1f);
    }
}
