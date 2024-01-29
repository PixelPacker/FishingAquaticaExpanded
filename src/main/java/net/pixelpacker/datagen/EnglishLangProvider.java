package net.pixelpacker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;

import java.nio.file.Path;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(BlockReg.BASIC_CRATE, "Basic Crate");
        translationBuilder.add(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("fishingaquaticaexpanded:item_group")), "Fishing Aquatica Expanded");
        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/fishingaquaticaexpanded/lang/en_us.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
