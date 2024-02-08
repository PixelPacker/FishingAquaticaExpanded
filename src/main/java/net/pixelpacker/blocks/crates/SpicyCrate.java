package net.pixelpacker.blocks.crates;

import net.pixelpacker.blocks.crates.particles.SparkleCrateParticle;
import net.pixelpacker.blocks.crates.sounds.SparkleCrateSound;
import net.pixelpacker.blocks.crates.util.Crate;

public class SpicyCrate extends Crate {
    public SpicyCrate(Settings settings) {
        super(settings);
    }

    @Override
    public void setCrateSound(){ crateSound = new SparkleCrateSound(); }

    @Override
    public void setCrateParticle(){ crateParticle = new SparkleCrateParticle();}
}
