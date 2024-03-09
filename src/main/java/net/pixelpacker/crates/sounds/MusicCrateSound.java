package net.pixelpacker.crates.sounds;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.registers.SoundReg;

public class MusicCrateSound extends BasicCrateSound{
    @Override
    public void playSound(ServerWorld world, BlockPos pos){
        play(world, pos, SoundReg.MUSIC_CRATE_SOUND_EVENT);
        play(world, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP);
        play(world, pos, SoundEvents.ENTITY_GENERIC_EXPLODE);
    }
}
