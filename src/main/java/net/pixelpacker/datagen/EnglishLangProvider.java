package net.pixelpacker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;
import net.pixelpacker.registers.ItemReg;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(BlockReg.BASIC_CRATE, "Basic Crate");

        translationBuilder.add(ItemReg.LOOT_CRATE_FISHING_ROD, "Loot Crate Fishing Rod");

        translationBuilder.add(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("fishingaquaticaexpanded:item_group")), "Fishing Aquatica Expanded");


        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/fishingaquaticaexpanded/lang/en_us.json").get();

            //These lines should be removed, this is stupid but the only workaround I could think of because of a silly exception being thrown from previously added translations
            File file = new File(String.valueOf(existingFilePath));
            file.setWritable(true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(existingFilePath.toString()));
            bufferedOutputStream.write("{}".getBytes());
            bufferedOutputStream.flush();
            translationBuilder.add(existingFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
