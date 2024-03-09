package net.pixelpacker.crates.particles;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.core.jmx.Server;

public class MusicCrateParticles extends BasicCrateParticle{
    @Override
    public void spawnParticles(ServerWorld world, BlockPos pos){
        spawn(ParticleTypes.NOTE, world, pos, 5);
        spawn(ParticleTypes.EXPLOSION, world, pos, 2);
    }
}
