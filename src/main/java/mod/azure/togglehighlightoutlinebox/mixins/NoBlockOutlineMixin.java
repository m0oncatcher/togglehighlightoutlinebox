package mod.azure.togglehighlightoutlinebox.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import mod.azure.togglehighlightoutlinebox.CommonMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class NoBlockOutlineMixin {

    @Inject(method = "renderBlockOutline", at = @At("HEAD"), cancellable = true)
    private void onRenderBlockOutline(MultiBufferSource.BufferSource bufferSource,
                                      PoseStack poseStack,
                                      boolean translucent,
                                      LevelRenderState renderState,
                                      CallbackInfo ci) {
        if (CommonMod.disableOutline) {
            ci.cancel();
        }
    }
}
