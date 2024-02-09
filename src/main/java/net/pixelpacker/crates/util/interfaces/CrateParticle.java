package net.pixelpacker.crates.util.interfaces;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public interface CrateParticle {
    public void spawnParticles(ServerWorld world, BlockPos pos);
}
