package com.circle.hamzasapes.client.model;

import com.circle.hamzasapes.HamzasApes;
import com.circle.hamzasapes.common.entity.JapaneseMacaqueEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class JapaneseMacaqueModel extends AnimatedGeoModel<JapaneseMacaqueEntity> {

    @Override
    public ResourceLocation getModelLocation(JapaneseMacaqueEntity object) {
        return new ResourceLocation(HamzasApes.MOD_ID, "geo/japanese_macaque.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(JapaneseMacaqueEntity object) {
        return new ResourceLocation(HamzasApes.MOD_ID, "textures/entity/japanese_macaque.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(JapaneseMacaqueEntity animatable) {
        return new ResourceLocation(HamzasApes.MOD_ID, "animations/japanese_macaque.animation.json");
    }

    @Override
    public void setLivingAnimations(JapaneseMacaqueEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));

        IBone root = this.getAnimationProcessor().getBone("root");
        if (entity.isBaby()) {
            root.setScaleX(0.5F);
            root.setScaleY(0.5F);
            root.setScaleZ(0.5F);
            root.setPositionY(-0.1F);
        } else {
            root.setPositionY(-0.1F);
        }
    }
}
