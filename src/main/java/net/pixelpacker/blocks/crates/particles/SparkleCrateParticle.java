package net.pixelpacker.blocks.crates.particles;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.blocks.crates.util.BasicCrateParticle;

public class SparkleCrateParticle extends BasicCrateParticle {
    @Override
    public void spawnParticles(ServerWorld world, BlockPos pos){
        spawn(ParticleTypes.FLASH, world, pos);
        spawn(ParticleTypes.FIREWORK, world, pos, 50, 0.1f);
        spawn(ParticleTypes.POOF, world, pos, 3);
        spawn(ParticleTypes.SMOKE, world, pos);
    }
}
