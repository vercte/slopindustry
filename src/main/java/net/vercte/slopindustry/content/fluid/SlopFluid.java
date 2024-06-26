package net.vercte.slopindustry.content.fluid;

import net.vercte.slopindustry.content.registry.FluidRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

@SuppressWarnings("null")
public abstract class SlopFluid extends BasicFluid {
    @Override
    public Fluid getSource() {
        return FluidRegistry.SOURCE_SLOP;
    }

    @Override
    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_SLOP;
    }

    @Override
    public Item getBucket() {
        return FluidRegistry.SLOP_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return FluidRegistry.SLOP.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 25;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return 2;
    }

    public static class Flowing extends SlopFluid {
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

    public static class Source extends SlopFluid {
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

