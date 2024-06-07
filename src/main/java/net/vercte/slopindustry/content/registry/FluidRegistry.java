package net.vercte.slopindustry.content.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.vercte.slopindustry.SlopIndustry;
import net.vercte.slopindustry.content.fluid.SlopFluid;
import net.vercte.slopindustry.content.fluid.SlopFluidBlock;

public class FluidRegistry {
    public static void onInitialize() {}

    public static final FlowingFluid SOURCE_SLOP;
    public static final FlowingFluid FLOWING_SLOP;
    public static final Item SLOP_BUCKET;
    public static final Block SLOP;

    static {
        SOURCE_SLOP = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("slop"), new SlopFluid.Source());
        FLOWING_SLOP = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("flowing_slop"), new SlopFluid.Flowing());
        SLOP_BUCKET = Registry.register(BuiltInRegistries.ITEM, SlopIndustry.id("slop_bucket"), 
            new BucketItem(SOURCE_SLOP, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1))
        );
        SLOP = Registry.register(BuiltInRegistries.BLOCK, SlopIndustry.id("slop"),
            new SlopFluidBlock(SOURCE_SLOP, FabricBlockSettings.copy(Blocks.WATER).mapColor(MapColor.COLOR_BROWN))
        );
    }
}
