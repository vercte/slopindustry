package net.vercte.slopindustry.content.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class FluidRendererRegistry {
    public static void onInitialize() {}

    static {
        FluidRenderHandlerRegistry.INSTANCE.register(FluidRegistry.SOURCE_SLOP, FluidRegistry.FLOWING_SLOP, new SimpleFluidRenderHandler(
            new ResourceLocation("minecraft:block/water_still"),
            new ResourceLocation("minecraft:block/water_flow"),
            0x2e1b0c
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), FluidRegistry.SOURCE_SLOP, FluidRegistry.FLOWING_SLOP);
    }
}
