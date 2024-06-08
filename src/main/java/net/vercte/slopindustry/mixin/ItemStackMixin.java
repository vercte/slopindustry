package net.vercte.slopindustry.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.vercte.slopindustry.content.registry.ItemRegistry;
import net.vercte.slopindustry.content.registry.SlopIndustryDamageTypes;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void finishUsingItem(Level level, LivingEntity entity, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack activeItem = entity.getUseItem();

        if(activeItem.isEdible()) {
            if(activeItem.is(ItemRegistry.GLASS_SHARDS)) {
                entity.hurt(SlopIndustryDamageTypes.of(level, SlopIndustryDamageTypes.FATAL_ROCK_CANDY), 4.0F);
            }

            CompoundTag tag = activeItem.getTag();
            if(tag != null && tag.getBoolean("SpikedWithGlassShards")) {
                entity.hurt(SlopIndustryDamageTypes.of(level, SlopIndustryDamageTypes.FATAL_ROCK_CANDY), 4.0F);
            }
        }
    }
}
