package com.teamabode.greenery.mixin;

import com.teamabode.greenery.registry.ModTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(Llama.class)
public class LlamaMixin extends AbstractChestedHorse {

    protected LlamaMixin(EntityType<? extends AbstractChestedHorse> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        super.tick();
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate(0.2), (entity) -> entity.getType().is(ModTags.CAN_RIDE_LLAMAS));
        if (!list.isEmpty()) {

            boolean rideConditions = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player) && this.isTamed();

            for (Entity entity : list) {
                if (!entity.hasPassenger(this)) {
                    if (rideConditions && this.getPassengers().size() < 1 && !entity.isPassenger()) {
                        entity.startRiding(this);
                    } else {
                        this.push(entity);
                    }
                }
            }
        }
    }


    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().size() < 1 && !this.isEyeInFluid(FluidTags.WATER);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.isEmpty() && !player.isCrouching() && !this.getPassengers().isEmpty()) {
            this.unRide();
            this.level.playSound(null, this.getOnPos(), SoundEvents.LLAMA_AMBIENT, SoundSource.NEUTRAL, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }
}
