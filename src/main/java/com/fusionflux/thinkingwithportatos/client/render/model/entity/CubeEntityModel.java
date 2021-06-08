package com.fusionflux.thinkingwithportatos.client.render.model.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CubeEntityModel extends EntityModel<CubeEntity> {

    private final ModelPart cube;

    public CubeEntityModel() {
        textureWidth = 64;
        textureHeight = 64;
        cube = new ModelPart(this, 0, 0).addCuboid(-5, -5, -5, 10, 10, 10);
    }

    @Override
    public void setAngles(CubeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        // render cube
        cube.render(matrices, vertices, light, overlay);
    }
}
