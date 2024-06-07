package net.vercte.slopindustry.content.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

@SuppressWarnings("null")
public class SlopLiquidBlock extends LiquidBlock {
    public SlopLiquidBlock(FlowingFluid fluid, Properties properties) {
        super(fluid, properties);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 50, 0, true, false, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 50, 0, true, false, true));
        }
    }
}
