package com.fusionflux.thinkingwithportatos;

import com.fusionflux.thinkingwithportatos.accessor.QuaternionHandler;
import com.fusionflux.thinkingwithportatos.blocks.ThinkingWithPortatosBlocks;
import com.fusionflux.thinkingwithportatos.client.ThinkingWithPortatosClient;
import com.fusionflux.thinkingwithportatos.config.ThinkingWithPortatosConfig;
import com.fusionflux.thinkingwithportatos.entity.ThinkingWithPortatosEntities;
import com.fusionflux.thinkingwithportatos.items.ThinkingWithPortatosItems;
import com.fusionflux.thinkingwithportatos.packet.ThinkingWithPortatosServerPackets;
import com.fusionflux.thinkingwithportatos.physics.BodyGrabbingManager;
import com.fusionflux.thinkingwithportatos.sound.ThinkingWithPortatosSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ThinkingWithPortatos implements ModInitializer {
    public static final ThinkingWithPortatosConfig CONFIG = new ThinkingWithPortatosConfig();
    public static final BodyGrabbingManager bodyGrabbingManager = new BodyGrabbingManager(true);
    public static final String MODID = "thinkingwithportatos";

    public static final ItemGroup ThinkingWithPortatosGroup = FabricItemGroupBuilder.build(
            id("general"),
            () -> new ItemStack(ThinkingWithPortatosItems.PORTAL_GUN));

    public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }

    public static BodyGrabbingManager getBodyGrabbingManager(boolean client) {
        if (client) {
            return ThinkingWithPortatosClient.bodyGrabbingManager;
        } else {
            return bodyGrabbingManager;
        }
    }

    @Override
    public void onInitialize() {
        QuaternionHandler.QUATERNION_HANDLER.getClass();
        ThinkingWithPortatosConfig.register();
        ThinkingWithPortatosBlocks.registerBlocks();
        ThinkingWithPortatosItems.registerItems();
        ThinkingWithPortatosEntities.registerEntities();
        ThinkingWithPortatosServerPackets.registerPackets();
        ThinkingWithPortatosSounds.registerSounds();
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> bodyGrabbingManager.grabInstances.clear());
        ServerTickEvents.END_SERVER_TICK.register(server -> bodyGrabbingManager.tick());
        FlammableBlockRegistry.getDefaultInstance().add(ThinkingWithPortatosBlocks.NEUROTOXIN_BLOCK,10000,10000);
    }
}
