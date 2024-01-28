package net.pixelpacker;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pixelpacker.datagen.EnglishLangProvider;
import net.pixelpacker.datagen.SimpleModelGenerator;

public class FishingAquaticaExpandedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(SimpleModelGenerator::new);
		pack.addProvider(EnglishLangProvider::new);
	}
}
