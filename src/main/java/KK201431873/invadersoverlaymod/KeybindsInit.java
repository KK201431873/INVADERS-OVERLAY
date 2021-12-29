package KK201431873.invadersoverlaymod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeybindsInit {
    public static KeyBinding HUD_CONFIG;

    public static void register() {
        HUD_CONFIG = new KeyBinding("Open HUD Configuration", Keyboard.KEY_RSHIFT, "Invaders Overlay Mod");
        ClientRegistry.registerKeyBinding(HUD_CONFIG);
    }

    private static KeyBinding create(String name, int key) {
        return new KeyBinding("key." + InvadersOverlayMod.MODID + "." + name, key, "key.category." + InvadersOverlayMod.MODID);
    }
}
