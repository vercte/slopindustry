package net.vercte.slopindustry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.vercte.slopindustry.content.registry.FluidRegistry;
import net.vercte.slopindustry.content.registry.ItemRegistry;
import net.vercte.slopindustry.content.registry.SlopIndustryRecipeTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlopIndustry implements ModInitializer {
	public static final String ID = "slopindustry";
	public static final String NAME = "SlopIndustry";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("me when mom brings home the sludge! like and share if you agree");
		FluidRegistry.onInitialize();
		ItemRegistry.onInitialize();

		SlopIndustryRecipeTypes.onInitialize();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
