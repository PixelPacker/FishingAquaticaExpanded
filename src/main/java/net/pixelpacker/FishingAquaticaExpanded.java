package net.pixelpacker;

import net.fabricmc.api.ModInitializer;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;
import net.pixelpacker.registers.ItemReg;
import net.pixelpacker.util.config.FAEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class FishingAquaticaExpanded implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("fishingaquaticaexpanded");
	public static final String MODID = "fishingaquaticaexpanded";
	public static final FAEConfig CONFIG = FAEConfig.createAndLoad();
	public static final Boolean DebugMode = CONFIG.debugMode();


	public static final Random rand = new Random();
	public static final BlockReg blockReg = new BlockReg();
	public static final ItemGroupRegister itemGroupReg = new ItemGroupRegister();
	public static final ItemReg itemReg = new ItemReg();


	@Override
	public void onInitialize() {
		blockReg.registerBlocks();
		itemReg.registerItems();
		itemGroupReg.register();
		LOGGER.info("Making fishing better one step at a time.");
	}
}