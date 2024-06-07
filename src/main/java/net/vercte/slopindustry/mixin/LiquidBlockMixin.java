package net.vercte.slopindustry.mixin;

import net.vercte.slopindustry.content.fluid.LiquidMudFluid;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

@Mixin(LiquidBlock.class)
public abstract class LiquidBlockMixin {
    @Accessor abstract public FlowingFluid getFluid();

    @Inject(at = @At("TAIL"), method = "shouldSpreadLiquid(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;)V", cancellable = true)
    private void shouldSpreadLiquid(Level level, BlockPos pos, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(getFluid() instanceof LiquidMudFluid) {
            for (Direction direction : LiquidBlock.POSSIBLE_FLOW_DIRECTIONS) {
                BlockPos blockPos = pos.relative(direction.getOpposite());
                if (!level.getBlockState(blockPos).is(Blocks.MAGMA_BLOCK)) continue;
                level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                cir.setReturnValue(false);
                return;
            }
        }
        cir.setReturnValue(true);
    }
}
