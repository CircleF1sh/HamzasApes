package com.circle.hamzasapes.client.renderer;

import com.circle.hamzasapes.client.model.JapaneseMacaqueModel;
import com.circle.hamzasapes.common.entity.JapaneseMacaqueEntity;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.SnowGolemRenderer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class JapeneseMacaqueRenderer extends GeoEntityRenderer<JapaneseMacaqueEntity> {

    public JapeneseMacaqueRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JapaneseMacaqueModel());
    }
}
