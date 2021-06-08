package com.fusionflux.thinkingwithportatos.client.render;

import com.fusionflux.thinkingwithportatos.ThinkingWithPortatos;
import com.fusionflux.thinkingwithportatos.client.render.model.entity.CubeEntityModel;
import dev.lazurite.rayon.core.impl.util.math.QuaternionHelper;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Quaternion;

public class CubeEntityRenderer extends EntityRenderer<CubeEntity> {
    private static final Identifier BASE_TEXTURE = new Identifier(ThinkingWithPortatos.MODID, "textures/entity/cube.png");
    private static final Identifier COMPANION_TEXTURE = new Identifier(ThinkingWithPortatos.MODID, "textures/entity/companion_cube.png");
    protected final CubeEntityModel model = new CubeEntityModel();
    private final boolean companion;

    public CubeEntityRenderer(EntityRenderDispatcher dispatcher, boolean companion) {
        super(dispatcher);
        this.shadowRadius = 0.45F;
        this.companion = companion;
    }

    @Override
    public void render(CubeEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        Quaternion orientation = QuaternionHelper.bulletToMinecraft(entity.getPhysicsRotation(new com.jme3.math.Quaternion(), tickDelta));

        matrices.push();
        matrices.multiply(orientation);

        this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(this.getTexture(entity))), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return companion ? COMPANION_TEXTURE : BASE_TEXTURE;
    }
}
