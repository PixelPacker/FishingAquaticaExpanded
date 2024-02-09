package net.pixelpacker.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemReg;

public class SimpleModelGenerator extends FabricModelProvider {
    public SimpleModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockReg.BASIC_CRATE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockReg.SPICY_CRATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
