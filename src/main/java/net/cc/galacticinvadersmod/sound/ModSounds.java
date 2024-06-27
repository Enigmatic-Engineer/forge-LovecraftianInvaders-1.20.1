package net.cc.galacticinvadersmod.sound;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GalacticInvadersMod.MOD_ID);

    public static final RegistryObject<SoundEvent> SCOUT_SCANNING_AMBIENT = registerSoundEvents("scout_scanning_ambient");
    public static final RegistryObject<SoundEvent> SCOUT_ENGAGING_TARGET = registerSoundEvents("scout_engaging_target");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(GalacticInvadersMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
