package net.vercte.slopindustry.content.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.vercte.slopindustry.SlopIndustry;
import net.vercte.slopindustry.content.fluid.LiquidMudFluid;
import net.vercte.slopindustry.content.fluid.SlopFluid;
import net.vercte.slopindustry.content.fluid.SlopLiquidBlock;

public class FluidRegistry {
    public static void onInitialize() {}

    // region Slop
    public static final FlowingFluid SOURCE_SLOP = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("slop"), new SlopFluid.Source());
    public static final FlowingFluid FLOWING_SLOP = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("flowing_slop"), new SlopFluid.Flowing());
    public static final Item SLOP_BUCKET = Registry.register(BuiltInRegistries.ITEM, SlopIndustry.id("slop_bucket"), 
        new BucketItem(SOURCE_SLOP, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1))
    );
    public static final Block SLOP = Registry.register(BuiltInRegistries.BLOCK, SlopIndustry.id("slop"),
        new SlopLiquidBlock(SOURCE_SLOP, FabricBlockSettings.copy(Blocks.WATER).mapColor(MapColor.COLOR_BROWN))
    );
    // endregion

    // region Liquid Mud
    public static final FlowingFluid SOURCE_LIQUID_MUD = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("liquid_mud"), new LiquidMudFluid.Source());
    public static final FlowingFluid FLOWING_LIQUID_MUD = Registry.register(BuiltInRegistries.FLUID, SlopIndustry.id("flowing_liquid_mud"), new LiquidMudFluid.Flowing());
    public static final Item LIQUID_MUD_BUCKET = Registry.register(BuiltInRegistries.ITEM, SlopIndustry.id("liquid_mud_bucket"), 
        new BucketItem(SOURCE_LIQUID_MUD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1))
    );
    public static final Block LIQUID_MUD = Registry.register(BuiltInRegistries.BLOCK, SlopIndustry.id("liquid_mud"),
        new LiquidBlock(SOURCE_LIQUID_MUD, FabricBlockSettings.copy(Blocks.WATER).mapColor(MapColor.COLOR_BROWN))
    );
    // endregion
}
