package com.circle.hamzasapes.common.registry;

import com.circle.hamzasapes.HamzasApes;
import com.circle.hamzasapes.common.entity.JapaneseMacaqueEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HamzasApesEntities {

    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, HamzasApes.MOD_ID);

    public static final RegistryObject<EntityType<JapaneseMacaqueEntity>> JAPANESE_MACAQUE = REGISTER.register("japanese_macaque",
            () -> EntityType.Builder.of(JapaneseMacaqueEntity::new, MobCategory.AMBIENT)
                    .sized(0.4F, 0.5F)
                    .build(new ResourceLocation(HamzasApes.MOD_ID, "japanese_macaque").toString()));

}
