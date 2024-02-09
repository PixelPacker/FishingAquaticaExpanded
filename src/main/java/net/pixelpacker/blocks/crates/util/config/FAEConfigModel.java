package net.pixelpacker.blocks.crates.util.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;
import net.pixelpacker.FishingAquaticaExpanded;

@Modmenu(modId = FishingAquaticaExpanded.MODID)
@Config(name="fae-config", wrapperName = "FAEConfig")
public class FAEConfigModel {
    @RangeConstraint(min = 0, max = 100)
    public int crateChance = 10;
    public boolean debugMode = false;
}
