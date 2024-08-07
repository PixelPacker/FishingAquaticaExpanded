package net.pixelpacker.util.datagen.lang;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.registers.BlockReg;
import net.pixelpacker.registers.ItemGroupRegister;
import net.pixelpacker.registers.ItemReg;

import java.io.*;
import java.nio.file.Path;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Blocks

        //Crates
        translationBuilder.add(BlockReg.MINER_CRATE, "Miner's Haul Crate");
        translationBuilder.add(BlockReg.MONSTER_CRATE, "Monster Hunter's Crate");
        translationBuilder.add(BlockReg.BLAZING_CRATE, "Blazing Crate");
        translationBuilder.add(BlockReg.MUSIC_CRATE, "Vinyl Collector's Crate");

        //Items
        translationBuilder.add(ItemReg.LOOT_CRATE_FISHING_ROD, "Loot Crate Fishing Rod");

        translationBuilder.add(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("fishingaquaticaexpanded:item_group")), "Fishing Aquatica Expanded");

        //Configs
        translationBuilder.add("text.config.fae-config.title", "Fishing Aquatica Expanded");
        translationBuilder.add("text.config.fae-config.option.crateChance", "Crate Chance");
        translationBuilder.add("text.config.fae-config.option.debugMode", "Debug Mode");

        //Audio
        translationBuilder.add("subtitles.fishingaquaticaexpanded.music_crate", "Music Crate Opened");
        /**
         * Old redundant code that was unused causing issues with datagen
         * Keeping in case it is needed to manually add translations instead of using datagen for all
        try {
            String filePathString = dataOutput.getModContainer().findPath("assets/fishingaquaticaexpanded/lang/en_us.json").get().toString();
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/fishingaquaticaexpanded/lang/en_us.json").get();
            File file = new File(filePathString);

            //These lines should be removed, this is stupid but the only workaround I could think of because of a silly exception being thrown from previously added translations

            file.setWritable(true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(existingFilePath.toString()));
            bufferedOutputStream.write("{}".getBytes());
            bufferedOutputStream.flush();

            translationBuilder.add(existingFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         **/
    }
}
