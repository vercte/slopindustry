package net.vercte.slopindustry;

import net.fabricmc.api.ClientModInitializer;
import net.vercte.slopindustry.content.registry.FluidRendererRegistry;

public class SlopIndustryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRendererRegistry.onInitialize();
    }
}
