package net.pixelpacker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.pixelpacker.registers.ItemReg;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ItemReg.LOOT_CRATE_FISHING_ROD)
                .pattern("  B")
                .pattern(" BS")
                .pattern("W G")
                .input('W', Items.STICK).input('B', Items.BLAZE_ROD).input('S', Items.STRING).input('G', Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ItemReg.LOOT_CRATE_FISHING_ROD),
                    FabricRecipeProvider.conditionsFromItem(ItemReg.LOOT_CRATE_FISHING_ROD))
                .offerTo(exporter);
    }
}
