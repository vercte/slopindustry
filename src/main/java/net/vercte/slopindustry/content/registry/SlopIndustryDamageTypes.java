package net.vercte.slopindustry.content.registry;

import net.vercte.slopindustry.SlopIndustry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class SlopIndustryDamageTypes {
    public static final ResourceKey<DamageType> FATAL_ROCK_CANDY = ResourceKey.create(Registries.DAMAGE_TYPE, SlopIndustry.id("fatal_rock_candy"));

    public static DamageSource of(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}
