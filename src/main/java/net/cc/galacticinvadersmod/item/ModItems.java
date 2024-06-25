package net.cc.galacticinvadersmod.item;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.entity.ModEntities;
import net.cc.galacticinvadersmod.item.custom.PortalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, GalacticInvadersMod.MOD_ID);

    public static final RegistryObject<Item> HORRIFIC_EYE = ITEMS.register("horrific_eye",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLESHY_MASS = ITEMS.register("fleshy_mass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PORTAL_DETECTOR = ITEMS.register("portal_detector",
            () -> new PortalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> SMALL_RIFT_SPAWN_EGG = ITEMS.register("small_rift_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SMALL_RIFT, 0xBF4BC5, 0x251D25,
                    new Item.Properties()));

    public static final RegistryObject<Item> EYE_SCOUT_SPAWN_EGG = ITEMS.register("eye_scout_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.EYE_SCOUT, 0x757166, 0xc21a00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
