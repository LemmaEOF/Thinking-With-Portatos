package com.fusionflux.thinkingwithportatos.items;

import com.fusionflux.thinkingwithportatos.ThinkingWithPortatos;
import com.fusionflux.thinkingwithportatos.config.ThinkingWithPortatosConfig;
import com.fusionflux.thinkingwithportatos.entity.ThinkingWithPortatosEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ThinkingWithPortatosItems {
    public static final ArmorMaterial FluxTechArmor = new FluxTechArmor();
    public static final GelOrb GEL_ORB = new GelOrb(new FabricItemSettings().group(ThinkingWithPortatos.ThinkingWithPortatosGroup).maxCount(64));
    public static final Item LONG_FALL_BOOTS = new ArmorItem(FluxTechArmor, EquipmentSlot.FEET, new Item.Settings().group(ThinkingWithPortatos.ThinkingWithPortatosGroup).fireproof());
    public static final PaintGun PAINT_GUN = new PaintGun(new FabricItemSettings().group(ThinkingWithPortatos.ThinkingWithPortatosGroup).maxCount(1).fireproof());
    public static final SpawnEggItem CUBE = new SpawnEggItem(ThinkingWithPortatosEntities.CUBE, 1, 1, new FabricItemSettings().group(ThinkingWithPortatos.ThinkingWithPortatosGroup));
    public static final SpawnEggItem COMPANION_CUBE = new SpawnEggItem(ThinkingWithPortatosEntities.COMPANION_CUBE, 1, 1, new FabricItemSettings().group(ThinkingWithPortatos.ThinkingWithPortatosGroup));

    public static void registerItems() {
        if (ThinkingWithPortatosConfig.get().enabled.enableLongFallBoots)
            Registry.register(Registry.ITEM, new Identifier(ThinkingWithPortatos.MODID, "long_fall_boots"), LONG_FALL_BOOTS);
        // Registry.register(Registry.ITEM, new Identifier(ThinkingWithPortatos.MODID, "gel_orb"), GEL_ORB);
        // Registry.register(Registry.ITEM, new Identifier(ThinkingWithPortatos.MODID, "paint_gun"), PAINT_GUN);
        Registry.register(Registry.ITEM, new Identifier(ThinkingWithPortatos.MODID, "cube"), CUBE);
        Registry.register(Registry.ITEM, new Identifier(ThinkingWithPortatos.MODID, "companion_cube"), COMPANION_CUBE);
    }
}
