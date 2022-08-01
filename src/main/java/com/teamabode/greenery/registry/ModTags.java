package com.teamabode.greenery.registry;

import com.teamabode.greenery.Greenery;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {

    public static final TagKey<EntityType<?>> CAN_RIDE_LLAMAS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Greenery.MODID,"can_ride_llamas"));
}
