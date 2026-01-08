package mod.azure.togglehighlightoutlinebox;

import net.minecraft.resources.Identifier;

public class CommonMod {
    public static boolean disableOutline = true;
    public static final String MOD_ID = "togglehighlightoutlinebox";

    public static final Identifier modResource(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void toggleOutline() {
        disableOutline = !disableOutline;
    }
}
