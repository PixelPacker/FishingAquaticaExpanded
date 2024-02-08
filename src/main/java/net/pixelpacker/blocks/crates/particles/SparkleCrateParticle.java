package net.pixelpacker.blocks.crates.particles;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.blocks.crates.util.BasicCrateParticle;

public class SparkleCrateParticle extends BasicCrateParticle {
    @Override
    public void spawnParticles(ServerWorld world, BlockPos pos){
        spawn(ParticleTypes.FLASH, world, pos, 0, 2);
        spawn(ParticleTypes.ELECTRIC_SPARK, world, pos, 0, 10);
        spawn(ParticleTypes.POOF, world, pos, 0, 2);
        spawn(ParticleTypes.SMOKE, world, pos, 0);
    }
}
