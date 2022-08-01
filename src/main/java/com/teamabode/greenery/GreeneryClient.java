package com.teamabode.greenery;

import com.teamabode.greenery.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;

public class GreeneryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlocks.MUSHROOM_PATCH_BLOCK, RenderType.cutout());
    }
}
