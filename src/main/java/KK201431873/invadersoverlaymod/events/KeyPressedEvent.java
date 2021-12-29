package KK201431873.invadersoverlaymod.events;

import KK201431873.invadersoverlaymod.KeybindsInit;
import KK201431873.invadersoverlaymod.hud.HUDConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyPressedEvent {
    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld == null) return;
        if (mc.currentScreen == null && KeybindsInit.HUD_CONFIG.isPressed()) {
            mc.displayGuiScreen(new HUDConfigScreen());
        }
    }
}
