package mod.azure.togglehighlightoutlinebox;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class FabricLibClientMod implements ClientModInitializer {

    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(
                    Identifier.fromNamespaceAndPath(CommonMod.MOD_ID, "binds")
            );

    @Override
    public void onInitializeClient() {
        Keybind.TOGGLE_VIEW = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.togglehighlightoutlinebox.toggle_view",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (Keybind.TOGGLE_VIEW.consumeClick()) {
                CommonMod.toggleOutline();
            }
        });
    }
}