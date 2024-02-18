package net.pixelpacker.util.datagen.tables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.pixelpacker.registers.BlockReg;

public class CrateLootTablesProvider extends FabricBlockLootTableProvider {
    public CrateLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Higher weights are more common
        addDrop(BlockReg.MINER_CRATE, LootTable.builder().pool(LootPool.builder()
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                .rolls(UniformLootNumberProvider.create(3, 5))
                    .with(ItemEntry.builder(Items.DIAMOND).weight(1))
                    .with(ItemEntry.builder(Items.EMERALD).weight(2))
                    .with(ItemEntry.builder(Items.RAW_GOLD).weight(3))
                    .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(3))
                    .with(ItemEntry.builder(Items.REDSTONE).weight(4))
                    .with(ItemEntry.builder(Items.RAW_IRON).weight(5))
                    .with(ItemEntry.builder(Items.RAW_COPPER).weight(5))
                    .with(ItemEntry.builder(Items.COAL).weight(6))
        ));

        addDrop(BlockReg.MONSTER_CRATE, LootTable.builder().pool(LootPool.builder()
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                .rolls(UniformLootNumberProvider.create(4, 6))
                    .with(ItemEntry.builder(Items.GHAST_TEAR).weight(1))
                    .with(ItemEntry.builder(Items.ENDER_PEARL).weight(1))
                    .with(ItemEntry.builder(Items.PRISMARINE_SHARD).weight(2))
                    .with(ItemEntry.builder(Items.PRISMARINE_CRYSTALS).weight(2))
                    .with(ItemEntry.builder(Items.PHANTOM_MEMBRANE).weight(2))
                    .with(ItemEntry.builder(Items.GUNPOWDER).weight(2))
                    .with(ItemEntry.builder(Items.SLIME_BALL).weight(3))
                    .with(ItemEntry.builder(Items.ARROW).weight(3))
                    .with(ItemEntry.builder(Items.BONE).weight(4))
                    .with(ItemEntry.builder(Items.ROTTEN_FLESH).weight(4))
        ));
    }
}
