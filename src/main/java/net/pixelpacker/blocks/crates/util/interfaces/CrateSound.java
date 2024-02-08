package net.pixelpacker.blocks.crates.util.interfaces;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public interface CrateSound {
    public void playSound(ServerWorld world, BlockPos pos);
}
