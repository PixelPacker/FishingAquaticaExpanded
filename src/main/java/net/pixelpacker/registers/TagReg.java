package net.pixelpacker.registers;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagReg {
    public static final TagKey<Item> FISHING_RODS = TagKey.of(RegistryKeys.ITEM, new Identifier("fishingaquaticaexpanded", "fishing_rods"));
    public static final TagKey<Item> T1_LOOT_CRATE_RODS = TagKey.of(RegistryKeys.ITEM, new Identifier("fishingaquaticaexpanded", "t1_loot_crate_rods"));
}
