package snownee.fruits.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import snownee.fruits.Hook;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {

	@Shadow
	@Final
	private Minecraft minecraft;

	@Inject(at = @At("RETURN"), method = "pick")
	public void fruits_pick(float partialTicks, CallbackInfo cir) {
		Hook.modifyRayTraceResult(minecraft);
	}
}
