package net.vercte.slopindustry.content.item.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GlassShardsItem extends Item {
    public GlassShardsItem() {
        super(new Item.Properties().food(
                new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.1f)
                    .alwaysEat()
                    .fast()
                    .build()
            ));
    }
}
