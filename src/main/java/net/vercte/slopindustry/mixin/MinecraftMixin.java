package net.vercte.slopindustry.mixin;

import net.minecraft.client.Minecraft;

import net.minecraft.client.main.GameConfig;
import net.vercte.slopindustry.SlopIndustry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void example$init(GameConfig gameConfig, CallbackInfo ci) {
		SlopIndustry.LOGGER.info("Hello from {}", SlopIndustry.NAME);
	}
}
 