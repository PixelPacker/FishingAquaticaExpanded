package net.pixelpacker.blocks.crates.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pixelpacker.FishingAquaticaExpanded;

public class CrateSound {

    float pitch = randomizePitchAndVol();
    float vol = randomizePitchAndVol();

    public void playSound(World world, BlockPos pos){
        if(!world.isClient){
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, pitch, vol);
        }
    }

    public float randomizePitchAndVol(){
        return FishingAquaticaExpanded.rand.nextFloat(0.5f, 1f);
    }
}
