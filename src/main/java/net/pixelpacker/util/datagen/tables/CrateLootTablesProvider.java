package net.pixelpacker.util.datagen.tables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.pixelpacker.registers.BlockReg;

public class CrateLootTablesProvider extends FabricBlockLootTableProvider {
    public CrateLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Higher weights are more common
        addDrop(BlockReg.BASIC_CRATE, LootTable.builder().pool(LootPool.builder()
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                .rolls(ConstantLootNumberProvider.create(3.0f))
                .with(ItemEntry.builder(Items.DIAMOND).weight(1))
                .with(ItemEntry.builder(Items.EMERALD).weight(2))
                .with(ItemEntry.builder(Items.COAL).weight(4))
        ));

        addDrop(BlockReg.SPICY_CRATE, LootTable.builder().pool(LootPool.builder()
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                .rolls(ConstantLootNumberProvider.create(5.0f))
                .with(ItemEntry.builder(Items.BLAZE_ROD).weight(1))
                .with(ItemEntry.builder(Items.TNT).weight(1))
                .with(ItemEntry.builder(Items.BLAZE_POWDER).weight(2))
                .with(ItemEntry.builder(Items.FIRE_CHARGE).weight(4))
        ));
    }
}
