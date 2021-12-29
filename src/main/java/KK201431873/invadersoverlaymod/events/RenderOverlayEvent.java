package KK201431873.invadersoverlaymod.events;

import KK201431873.invadersoverlaymod.InvadersOverlayMod;
import KK201431873.invadersoverlaymod.hud.HUDConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderOverlayEvent {
    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof HUDConfigScreen)) {
            InvadersOverlayMod.instance.hudManager.renderMods();
        }
    }
}
