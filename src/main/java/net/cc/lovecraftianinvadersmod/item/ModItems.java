package net.cc.lovecraftianinvadersmod.item;

import net.cc.lovecraftianinvadersmod.LovecraftianInvadersMod;
import net.cc.lovecraftianinvadersmod.item.custom.PortalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, LovecraftianInvadersMod.MOD_ID);

    public static final RegistryObject<Item> HORRIFIC_EYE = ITEMS.register("horrific_eye",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLESHY_MASS = ITEMS.register("fleshy_mass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PORTAL_DETECTOR = ITEMS.register("portal_detector",
            () -> new PortalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
