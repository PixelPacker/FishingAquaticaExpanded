package net.pixelpacker.util.datagen.tables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.LootTableReg;

import java.util.function.BiConsumer;

public class FishingCrateTablesProvider extends SimpleFabricLootTableProvider {
    public FishingCrateTablesProvider(FabricDataOutput output) {
        super(output, LootContextTypes.FISHING);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(LootTableReg.TIER_ONE_CRATES, LootTable.builder().pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0f))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                .with(ItemEntry.builder(BlockReg.BASIC_CRATE).weight(2))
                .with(ItemEntry.builder(BlockReg.SPICY_CRATE).weight(1))
        ));
    }
}
