package net.vercte.slopindustry.content.recipe;

import net.vercte.slopindustry.content.registry.ItemRegistry;
import net.vercte.slopindustry.content.registry.SlopIndustryRecipeTypes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

@SuppressWarnings("null")
public class GlassShardsSpikingRecipe extends CustomRecipe {
    public static final RecipeType<GlassShardsSpikingRecipe> TYPE = new RecipeType<GlassShardsSpikingRecipe>(){};

    public GlassShardsSpikingRecipe(ResourceLocation resourceLocation, CraftingBookCategory category) {
        super(resourceLocation, category);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    public boolean matches(CraftingContainer container, Level level) {
        int glassShards = 0;
        int foods = 0;

        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if(!stack.isEmpty()) {
                if(stack.is(ItemRegistry.GLASS_SHARDS)) glassShards++;
                if(stack.isEdible()) {
                    foods++;
                    CompoundTag tag = stack.getTag();
                    if(tag != null && tag.getBoolean("SpikedWithGlassShards")) return false;
                }
                if(glassShards > 1 || foods > 1) return false;
            }
        }

        return glassShards == 1 && foods == 1;
    }

    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack food = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if(!stack.isEmpty()) {
                if(stack.isEdible()) food = stack;
            }
        }

        ItemStack spikedFood = food.copy();
        CompoundTag tag = spikedFood.getOrCreateTag();
        tag.putBoolean("SpikedWithGlassShards", true);
        spikedFood.setTag(tag);

        return spikedFood;
    }

    public RecipeSerializer<GlassShardsSpikingRecipe> getSerializer() {
        return SlopIndustryRecipeTypes.GLASS_SHARDS_SPIKING_RECIPE_SERIALIZER;
    }
}
