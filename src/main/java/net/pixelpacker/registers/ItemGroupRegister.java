package net.pixelpacker.registers;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;

public class ItemGroupRegister {
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockReg.MINER_CRATE))
            .displayName(Text.translatable("itemGroup.fishingaquaticaexpanded.item_group"))
            .entries((context, entries) -> {
                entries.add(BlockReg.MINER_CRATE);
                entries.add(BlockReg.MONSTER_CRATE);
                entries.add(BlockReg.BLAZING_CRATE);
                entries.add(BlockReg.MUSIC_CRATE);
                entries.add(ItemReg.LOOT_CRATE_FISHING_ROD);
            })
            .build();

    public void register(){
        Registry.register(Registries.ITEM_GROUP, new Identifier(FishingAquaticaExpanded.MODID, "item_group"), ITEM_GROUP);
    }
}
