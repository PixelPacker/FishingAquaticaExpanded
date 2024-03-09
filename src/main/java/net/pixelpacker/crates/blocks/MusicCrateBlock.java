package net.pixelpacker.crates.blocks;

import net.pixelpacker.crates.particles.MusicCrateParticles;
import net.pixelpacker.crates.sounds.MusicCrateSound;

public class MusicCrateBlock extends CrateBlock{
    public MusicCrateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void setCrateSound(){
        crateSound = new MusicCrateSound();
    }

    @Override
    public void setCrateParticle(){
        crateParticle = new MusicCrateParticles();
    }
}
