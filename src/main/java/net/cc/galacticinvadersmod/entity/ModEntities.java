package net.cc.galacticinvadersmod.entity;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.entity.custom.EyeScoutEntity;
import net.cc.galacticinvadersmod.entity.custom.SmallRiftEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GalacticInvadersMod.MOD_ID);

    public static final RegistryObject<EntityType<SmallRiftEntity>> SMALL_RIFT =
            ENTITY_TYPES.register("small_rift", () -> EntityType.Builder.of(SmallRiftEntity::new, MobCategory.MONSTER)
                    .sized(1.3f, 2.0f).build("small_rift"));

    public static final RegistryObject<EntityType<EyeScoutEntity>> EYE_SCOUT =
            ENTITY_TYPES.register("eye_scout", () -> EntityType.Builder.of(EyeScoutEntity::new, MobCategory.MONSTER)
                    .sized(0.3f, 0.7f).build("eye_scout"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
