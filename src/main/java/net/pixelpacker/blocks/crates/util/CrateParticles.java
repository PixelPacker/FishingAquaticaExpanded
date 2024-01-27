package net.pixelpacker.blocks.crates.util;

import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pixelpacker.FishingAquaticaExpanded;
import org.joml.Vector3d;

public class CrateParticles {

    public int maxParticles = 5;

    public void spawnParticles(ServerWorld world, BlockPos pos){
        pSpawn(ParticleTypes.EXPLOSION, world, pos);
        pSpawn(ParticleTypes.SMOKE, world, pos);
    }

    private void pSpawn(ParticleEffect particleType, ServerWorld world, BlockPos pos){
        //world.spawnParticles(ParticleTypes.EXPLOSION, pos.getX(), pos.getY(), pos.getZ(), randomizeAmount(), particleVel.x, particleVel.y, particleVel.z, 0);
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
