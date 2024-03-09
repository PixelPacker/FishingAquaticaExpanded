package net.pixelpacker.registers;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundReg {
    public static final Identifier MUSIC_CRATE_SOUND_ID = new Identifier("fishingaquaticaexpanded:music_crate");
    public static SoundEvent MUSIC_CRATE_SOUND_EVENT = SoundEvent.of(MUSIC_CRATE_SOUND_ID);

    public void registerSounds(){
        register(MUSIC_CRATE_SOUND_ID, MUSIC_CRATE_SOUND_EVENT);
    }

    private void register(Identifier id, SoundEvent soundEvent){
        Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }
}
