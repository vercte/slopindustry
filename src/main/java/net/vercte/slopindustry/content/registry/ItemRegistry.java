package net.vercte.slopindustry.content.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.vercte.slopindustry.SlopIndustry;
import net.vercte.slopindustry.content.item.food.GlassShardsItem;

public class ItemRegistry {
    public static void onInitialize() {}

    // region Foods
    public static final Item GLASS_SHARDS = Registry.register(BuiltInRegistries.ITEM, SlopIndustry.id("glass_shards"), new GlassShardsItem());
    // endregion
}
