package net.pixelpacker.blocks.crates.util;


import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.blocks.crates.util.interfaces.CrateParticle;
import org.joml.Vector3d;

public class BasicCrateParticle implements CrateParticle {
    /**
     * <h3>Spawns particles at target location</h3>
     * <p>Can be overwritten to allow for different effects for different crates</p>
     * @param world Must be server world due to particle effects.
     * @param pos The position of the crate that was broken.
     */
    @Override
    public void spawnParticles(ServerWorld world, BlockPos pos){
        spawn(ParticleTypes.EXPLOSION, world, pos);
        spawn(ParticleTypes.SMOKE, world, pos);
    }

    public void spawn(ParticleEffect particleType, ServerWorld world, BlockPos pos){
        Vector3d particleVel = new Vector3d(randomizeVel(), randomizeVel(), randomizeVel());
        Vec3d loc = Vec3d.ofCenter(pos);
        world.spawnParticles(particleType, loc.x, loc.y, loc.z, 1, particleVel.x, particleVel.y, particleVel.z, 0);
    }

    public void spawn(ParticleEffect particleType, ServerWorld world, BlockPos pos, int amount){
        Vector3d particleVel = new Vector3d(randomizeVel(), randomizeVel(), randomizeVel());
        Vec3d loc = Vec3d.ofCenter(pos);
        world.spawnParticles(particleType, loc.x, loc.y, loc.z, amount, particleVel.x, particleVel.y, particleVel.z, 0);
    }

    public void spawn(ParticleEffect particleType, ServerWorld world, BlockPos pos, int amount, float speed){
        Vector3d particleVel = new Vector3d(randomizeVel(), randomizeVel(), randomizeVel());
        Vec3d loc = Vec3d.ofCenter(pos);
        world.spawnParticles(particleType, loc.x, loc.y, loc.z, amount, particleVel.x, particleVel.y, particleVel.z, speed);
    }
    public float randomizeVel(){
        return FishingAquaticaExpanded.rand.nextFloat(-0.1f, 0.11f);
    }
}
