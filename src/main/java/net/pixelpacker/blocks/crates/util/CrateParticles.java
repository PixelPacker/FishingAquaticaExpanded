package net.pixelpacker.blocks.crates.util;


import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.pixelpacker.FishingAquaticaExpanded;
import org.joml.Vector3d;

public class CrateParticles {

    public int maxParticles = 5;

    /**
     * <h3>Spawns particles at target location</h3>
     * <p>Can be overwritten to allow for different effects for different crates</p>
     * @param world Must be server world due to particle effects.
     * @param pos The position of the crate that was broken.
     */
    public void spawnParticles(ServerWorld world, BlockPos pos){
        pSpawn(ParticleTypes.EXPLOSION, world, pos);
        pSpawn(ParticleTypes.SMOKE, world, pos);
    }

    private void pSpawn(ParticleEffect particleType, ServerWorld world, BlockPos pos){
        Vector3d particleVel = new Vector3d(randomizeVel(), randomizeVel(), randomizeVel());
        world.spawnParticles(particleType, pos.getX(), pos.getY(), pos.getZ(), randomizeAmount(), particleVel.x, particleVel.y, particleVel.z, 0);
        if(FishingAquaticaExpanded.DebugMode){
            FishingAquaticaExpanded.LOGGER.info("Particle Vel x:" + particleVel.x);
        }
    }

    public float randomizeVel(){
        return FishingAquaticaExpanded.rand.nextFloat(-0.1f, 0.11f);
    }

    public int randomizeAmount(){
        return FishingAquaticaExpanded.rand.nextInt(1, 5+1);
    }
}
