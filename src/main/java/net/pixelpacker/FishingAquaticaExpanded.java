package net.pixelpacker;

import net.fabricmc.api.ModInitializer;

import net.pixelpacker.registers.BlockReg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class FishingAquaticaExpanded implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("fishingaquaticaexpanded");
	public static final String MODID = "fishingaquaticaexpanded";
	public static final Boolean DebugMode = true;

	public static final Random rand = new Random();
	public static final BlockReg blockReg = new BlockReg();



	@Override
	public void onInitialize() {
		blockReg.registerBlocks();
		LOGGER.info("Making fishing better one step at a time.");
	}
}