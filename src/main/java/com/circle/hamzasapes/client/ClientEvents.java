package com.circle.hamzasapes.client;

import com.circle.hamzasapes.HamzasApes;
import com.circle.hamzasapes.client.renderer.JapeneseMacaqueRenderer;
import com.circle.hamzasapes.common.registry.HamzasApesEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = HamzasApes.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HamzasApesEntities.JAPANESE_MACAQUE.get(), JapeneseMacaqueRenderer::new);
        }
    }
