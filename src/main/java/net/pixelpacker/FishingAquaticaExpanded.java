package net.pixelpacker;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class FishingAquaticaExpanded implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("fishingaquaticaexpanded");
	public static final String MODID = "fishingaquaticaexpanded";
	public static final Boolean DebugMode = true;

	public static final Random rand = new Random();
	public static final BlockReg blockReg = new BlockReg();
	public static final ItemGroupRegister itemGroupReg = new ItemGroupRegister();



	@Override
	public void onInitialize() {
		blockReg.registerBlocks();
		itemGroupReg.register();
		LOGGER.info("Making fishing better one step at a time.");
	}
}