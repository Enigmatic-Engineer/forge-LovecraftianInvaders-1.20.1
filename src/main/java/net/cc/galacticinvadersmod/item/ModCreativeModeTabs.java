package net.cc.galacticinvadersmod.item;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GalacticInvadersMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GALACTIC_INVADERS_TAB = CREATIVE_MODE_TABS.register("galactic_invaders_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HORRIFIC_EYE.get()))
                    .title(Component.translatable("creativetab.galactic_invaders_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HORRIFIC_EYE.get());
                        output.accept(ModItems.FLESHY_MASS.get());

                        output.accept(ModItems.SMALL_RIFT_SPAWN_EGG.get());
                        output.accept(ModItems.EYE_SCOUT_SPAWN_EGG.get());

                        output.accept(ModItems.PORTAL_DETECTOR.get());

                        output.accept(ModBlocks.FLESHY_BLOCK.get());
                        output.accept(ModBlocks.EYE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
