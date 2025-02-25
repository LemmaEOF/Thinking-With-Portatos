package com.fusionflux.thinkingwithportatos.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TallButton extends TallButtonVarient{
    public TallButton(AbstractBlock.Settings settings) {
        super(false, settings);
    }

    protected SoundEvent getClickSound(boolean powered) {
        return powered ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }
}
