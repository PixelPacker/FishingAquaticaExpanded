package net.pixelpacker.crates.util.interfaces;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public interface CrateSound {
    void playSound(ServerWorld world, BlockPos pos);
}
