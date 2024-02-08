package net.pixelpacker.blocks.crates.sounds;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.blocks.crates.util.BasicCrateSound;

public class SparkleCrateSound extends BasicCrateSound {
    @Override
    public void playSound(ServerWorld world, BlockPos pos){
        this.play(world, pos, SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE, .75f);
        this.play(world, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, .75f);
        this.play(world, pos, SoundEvents.ENTITY_GENERIC_EXPLODE);
    }
}
