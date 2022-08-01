package com.teamabode.greenery.registry;

import com.teamabode.greenery.Greenery;
import com.teamabode.greenery.block.MushroomPatchBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ModBlocks {

    public static final Block MUSHROOM_PATCH_BLOCK = new MushroomPatchBlock(Items.RED_MUSHROOM, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak());

    public static void register() {
        registerBlock("red_mushroom_patch", MUSHROOM_PATCH_BLOCK, CreativeModeTab.TAB_DECORATIONS);
    }

    public static void registerBlock(String id, Block block, CreativeModeTab tab) {
        ResourceLocation resourceLocation = new ResourceLocation(Greenery.MODID, id);
        Registry.register(Registry.BLOCK, resourceLocation, block);
        Registry.register(Registry.ITEM, resourceLocation, new BlockItem(block, new Item.Properties().tab(tab)));
    }

    public static void registerBlockNoItem(String id, Block block) {
        ResourceLocation resourceLocation = new ResourceLocation(Greenery.MODID, id);
        Registry.register(Registry.BLOCK, resourceLocation, block);
    }
}
