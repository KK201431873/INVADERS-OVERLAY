package KK201431873.invadersoverlaymod.hud.mod.impl;

import KK201431873.invadersoverlaymod.hud.mod.HudMod;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.awt.*;

public class OverlayMod extends HudMod {
    public OverlayMod(String cname, int cx, int cy) {
        super(cname, cx, cy);
    }

    public final int RESOURCECT = 12;

    /*
     ORDER: 1.shiny bar;
     2.super ultra sticky glue
     3.support rod
     4.space sand
     5.sharpened stone
     6.synthetic thread
     7.slime poop
     8.unidentified material
     9.bonding agent
     10.super shiny rock
     11.silicon
     12.gyroscope
     */

    ItemStack shiny_bar = new ItemStack(Items.gold_ingot),
              super_ultra_sticky_glue = new ItemStack(Items.clay_ball),
              support_rod = new ItemStack(Items.stick),
              space_sand = new ItemStack(ItemBlock.getItemFromBlock(Blocks.sand)),
              sharp_stone = new ItemStack(Items.flint),
              synthetic_thread = new ItemStack(Items.string),
              slime_poop = new ItemStack(Items.slime_ball),
              unidentified_material = new ItemStack(Items.iron_ingot),
              bonding_agent = new ItemStack(Items.redstone),
              super_shiny_rock = new ItemStack(Items.diamond),
              silicon = new ItemStack(Items.sugar),
              gyroscope = new ItemStack(Items.firework_charge);

    ItemStack[] itemstx = {
            shiny_bar,
            super_ultra_sticky_glue,
            support_rod,
            space_sand,
            sharp_stone,
            synthetic_thread,
            slime_poop,
            unidentified_material,
            bonding_agent,
            super_shiny_rock,
            silicon,
            gyroscope
    };

    int[] itemcounts = new int[RESOURCECT];

    private int[] maxlen = new int[4];

    public void draw() {
        RenderHelper.enableGUIStandardItemLighting();
        int transpColor = new Color(0, 0, 0, 26).getRGB(), startX = getX()-60, startY = getY()-(itemstx.length*5)-5, endX = getX()+(maxlen[0]+maxlen[1]+maxlen[2]+maxlen[3])*5-30, endY = getY()+(itemstx.length*5)+5;
        createBoxAndTitle(startX, startY, endX, endY, transpColor);

        int itemOvPosX = getX()-65+(maxlen[0]+maxlen[1])*5;
        int itemOvPosY;
        for (int ii = 0; ii < 2; ii++)
        {
            itemOvPosY = getY()-(itemstx.length*5);
            for (int iii = 0; iii < (itemstx.length + 1)/2; iii++)
            {
                EnumChatFormatting txtcolor;
                if (itemcounts[ii*6 + iii] < resourceGoals[ii*6+iii])
                {
                    txtcolor = EnumChatFormatting.RED;
                }
                else
                {
                    txtcolor = EnumChatFormatting.GREEN;
                }
                mc.getRenderItem().renderItemAndEffectIntoGUI(itemstx[ii*6 + iii], itemOvPosX, itemOvPosY);
                mc.getRenderItem().renderItemOverlayIntoGUI(fr, itemstx[ii*6 + iii], itemOvPosX, itemOvPosY, txtcolor + "" + itemcounts[ii*6 + iii] + "/" + resourceGoals[ii*6+iii]);
                itemOvPosY += 20;
            }
            itemOvPosX += 15 + (maxlen[2]+maxlen[3])*5;
        }
        RenderHelper.disableStandardItemLighting();
        
        //fr.drawString(name, getX(), getY(), -1);
        super.draw();
    }

    public void renderDummy(int mouseX, int mouseY)
    {
        RenderHelper.enableGUIStandardItemLighting();
        int transpColor = new Color(0, 0, 0, 26).getRGB(), startX = getX()-60, startY = getY()-(itemstx.length*5)-5, endX = getX()+(maxlen[0]+maxlen[1]+maxlen[2]+maxlen[3])*5-30, endY = getY()+(itemstx.length*5)+5;
        createBoxAndTitle(startX, startY, endX, endY, transpColor);
        drawBorderedBox(getX()-fr.getStringWidth("Drag This")-2, getY()-2, getX(), getY() + getHeight(), new Color(0, 0, 0, 139).getRGB());
        fr.drawString("Drag This", getX()-fr.getStringWidth("Drag This"), getY(), -1);
        RenderHelper.disableStandardItemLighting();
        super.renderDummy(mouseX, mouseY);
    }

    public void createBoxAndTitle(int startX, int startY, int endX, int endY, int transpColor) {
        initItemCounts();
        drawBorderedBox(startX, startY, endX, endY, transpColor);
        fr.drawString(name, (int) Math.round((startX+endX)/2-getWidth()/2), getY()-(itemstx.length*5)-14, 0xFFFF55); //color FFFF55
    }

    public int getWidth()
    {
        return fr.getStringWidth(name);
    }

    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }

    public int itemCount(Item it)
    {
        int ctitem = 0;
        for (int i = 0; i < mc.thePlayer.inventory.getSizeInventory(); i++)
        {
            if (mc.thePlayer.inventory.getStackInSlot(i) != null)
            {
                if (mc.thePlayer.inventory.getStackInSlot(i).getItem() == it)
                {
                    ctitem += mc.thePlayer.inventory.getStackInSlot(i).stackSize;
                }
            }
        }
        return ctitem;
    }

    public void initItemCounts() {
        int[] proxyMaxlen = new int[4];
        maxlen = proxyMaxlen;

        for (int ii = 0; ii < itemstx.length; ii++)
        {
            itemcounts[ii] = itemCount(itemstx[ii].getItem());
        }

        for (int ii = 0; ii < RESOURCECT; ii++)
        {
            if (ii < (RESOURCECT+1)/2)
            {
                maxlen[0] = Math.max(maxlen[0], (itemcounts[ii]+"").length());
                maxlen[1] = Math.max(maxlen[1], (resourceGoals[ii]+"").length());
            }
            else
            {
                maxlen[2] = Math.max(maxlen[2], (itemcounts[ii]+"").length());
                maxlen[3] = Math.max(maxlen[3], (resourceGoals[ii]+"").length());
            }
        }
    }
    
    public void drawBorderedBox(int sx, int sy, int ex, int ey, int color)
    {
        drawRect(sx, sy, ex, ey, color);
        drawHorizontalLine(sx, ex, sy, color);
        drawHorizontalLine(sx, ex, ey, color);
        drawVerticalLine(sx, sy, ey, color);
        drawVerticalLine(ex, sy, ey, color);
    }
}
