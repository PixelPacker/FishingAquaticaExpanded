package net.pixelpacker;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pixelpacker.util.datagen.tables.FishingCrateTablesProvider;
import net.pixelpacker.util.datagen.tags.BlockTagProvider;
import net.pixelpacker.util.datagen.lang.EnglishLangProvider;
import net.pixelpacker.util.datagen.RecipeGenerator;
import net.pixelpacker.util.datagen.SimpleModelGenerator;
import net.pixelpacker.util.datagen.tags.ItemTagProvider;
import net.pixelpacker.util.datagen.tables.CrateLootTablesProvider;

public class FishingAquaticaExpandedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(SimpleModelGenerator::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(EnglishLangProvider::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(CrateLootTablesProvider::new);
		pack.addProvider(FishingCrateTablesProvider::new);
	}
}
