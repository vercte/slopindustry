package net.vercte.slopindustry.content.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.vercte.slopindustry.SlopIndustry;
import net.vercte.slopindustry.content.recipe.GlassShardsSpikingRecipe;

public class SlopIndustryRecipeTypes {
    public static void onInitialize() {}

    public static RecipeType<GlassShardsSpikingRecipe> GLASS_SHARDS_SPIKING_RECIPE = Registry.register(BuiltInRegistries.RECIPE_TYPE, SlopIndustry.id("crafting_special_glass_shards_spiking"), GlassShardsSpikingRecipe.TYPE);
    public static RecipeSerializer<GlassShardsSpikingRecipe> GLASS_SHARDS_SPIKING_RECIPE_SERIALIZER = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, SlopIndustry.id("crafting_special_glass_shards_spiking"), new SimpleCraftingRecipeSerializer<>(GlassShardsSpikingRecipe::new));
}
