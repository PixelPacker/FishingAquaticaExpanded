package net.pixelpacker.registers;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagReg {
    public static final TagKey<Item> FISHING_RODS = TagKey.of(RegistryKeys.ITEM, new Identifier("fishing_aquatica_expanded", "fishing_rods"));
}
