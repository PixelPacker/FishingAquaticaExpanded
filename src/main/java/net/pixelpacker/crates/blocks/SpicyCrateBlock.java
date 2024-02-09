package net.pixelpacker.crates.blocks;

import net.pixelpacker.crates.particles.SparkleCrateParticle;
import net.pixelpacker.crates.sounds.SparkleCrateSound;
import net.pixelpacker.crates.util.Crate;

public class SpicyCrateBlock extends Crate {
    public SpicyCrateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void setCrateSound(){ crateSound = new SparkleCrateSound(); }

    @Override
    public void setCrateParticle(){ crateParticle = new SparkleCrateParticle();}
}
