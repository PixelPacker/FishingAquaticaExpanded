package net.pixelpacker.items.fishingrods;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;

public class LootCrateFishingRodItem extends FishingRodItem implements Vanishable {
    public LootCrateFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == Items.BLAZE_ROD;
    }
}
