package KK201431873.invadersoverlaymod.hud.mod;

import KK201431873.invadersoverlaymod.hud.DraggableComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class HudMod extends Gui {

    public Minecraft mc = Minecraft.getMinecraft();
    public FontRenderer fr = mc.fontRendererObj;

    public String name;
    public boolean enabled;
    public DraggableComponent drag;

    public int x, y;
    public int[] resourceGoals = {36, 84, 52, 36, 30, 16, 24, 40, 32, 11, 0, 0};

    public HudMod(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;

        drag = new DraggableComponent(x, y, getWidth(), getHeight(), 0x96000000);
    }

    public int getWidth() {
        return 50;
    }

    public int getHeight() {
        return 50;
    }

    public void draw() {

    }

    public void renderDummy(int mouseX, int mouseY) {
        drag.draw(mouseX, mouseY);
    }

    public int getX() {
        return drag.getxPosition();
    }

    public int getY() {
        return drag.getyPosition();
    }
}
