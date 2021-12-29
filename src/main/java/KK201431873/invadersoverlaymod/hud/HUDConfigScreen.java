package KK201431873.invadersoverlaymod.hud;

import KK201431873.invadersoverlaymod.InvadersOverlayMod;
import KK201431873.invadersoverlaymod.hud.mod.HudManager;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen {

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        InvadersOverlayMod.instance.hudManager.hudMods.get(HudManager.curTask).renderDummy(mouseX, mouseY);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

}
