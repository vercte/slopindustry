package net.vercte.slopindustry.content.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.vercte.slopindustry.content.registry.FluidRegistry;

public class TagGenerator {
    public static class FluidTagGenerator extends FabricTagProvider.FluidTagProvider {
        private static final TagKey<Fluid> WATER = TagKey.create(Registries.FLUID, new ResourceLocation("minecraft", "water"));

        public FluidTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        protected void addTags(HolderLookup.Provider arg) {
            getOrCreateTagBuilder(WATER)
                .add(FluidRegistry.SOURCE_SLOP)
                .add(FluidRegistry.FLOWING_SLOP);
        }
    }
}