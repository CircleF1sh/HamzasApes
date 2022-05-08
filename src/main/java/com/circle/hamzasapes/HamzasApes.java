package com.circle.hamzasapes;

import com.circle.hamzasapes.common.entity.JapaneseMacaqueEntity;
import com.circle.hamzasapes.common.registry.HamzasApesEntities;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HamzasApes.MOD_ID)
public class HamzasApes
{

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "hamzasapes";
    public static final List<Runnable> CALLBACKS = new ArrayList<>();


    public HamzasApes() {
        GeckoLib.initialize();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventForgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::setup);
        bus.addListener(this::registerClientSetup);
        bus.addListener(this::registerCommonEvents);

        eventForgeBus.addListener(this::onBiomeLoadingEvent);

        HamzasApesEntities.REGISTER.register(bus);
    }

    private void setup(EntityAttributeCreationEvent event) {
        event.put(HamzasApesEntities.JAPANESE_MACAQUE.get(), JapaneseMacaqueEntity.registerAttributes().build());
    }

    private void registerClientSetup(FMLClientSetupEvent event) {
        CALLBACKS.forEach(Runnable::run);
        CALLBACKS.clear();
    }

    private void registerCommonEvents(FMLCommonSetupEvent event) {
        SpawnPlacements.register(HamzasApesEntities.JAPANESE_MACAQUE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    private void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.ICY) {
            event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(HamzasApesEntities.JAPANESE_MACAQUE.get(), 30, 1, 6));
        }
    }
}
