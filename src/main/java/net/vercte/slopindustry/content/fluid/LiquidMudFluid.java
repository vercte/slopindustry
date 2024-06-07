package net.vercte.slopindustry.content.fluid;

import net.vercte.slopindustry.content.registry.FluidRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

@SuppressWarnings("null")
public abstract class LiquidMudFluid extends BasicFluid {
    @Override
    public Fluid getSource() {
        return FluidRegistry.SOURCE_LIQUID_MUD;
    }

    @Override
    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_LIQUID_MUD;
    }

    @Override
    public Item getBucket() {
        return FluidRegistry.LIQUID_MUD_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return FluidRegistry.LIQUID_MUD.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    protected void spreadTo(LevelAccessor level, BlockPos pos, BlockState blockState, Direction direction, FluidState fluidState) {
      

      super.spreadTo(level, pos, blockState, direction, fluidState);
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 15;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return 3;
    }

    public static class Flowing extends LiquidMudFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }

    public static class Source extends LiquidMudFluid {
        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
