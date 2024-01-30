package net.pixelpacker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.pixelpacker.registers.ItemReg;
import net.pixelpacker.registers.TagReg;
import java.util.concurrent.CompletableFuture;

public class TagProvider extends FabricTagProvider.ItemTagProvider{


    public TagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(TagReg.FISHING_RODS)
                .add(Items.FISHING_ROD)
                .add(ItemReg.LOOT_CRATE_FISHING_ROD);
    }
}
