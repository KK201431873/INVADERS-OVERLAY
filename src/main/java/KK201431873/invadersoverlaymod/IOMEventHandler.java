package KK201431873.invadersoverlaymod;

import KK201431873.invadersoverlaymod.hud.HUDConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class IOMEventHandler {

    /*@SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entity;
            System.out.println(":O player has joined its " + player.getName());
        }
    }*/

    /*@SubscribeEvent
    public void livingDrops(LivingDropsEvent event)
    {
        if (event.entity instanceof EntityMob && event.source.getSourceOfDamage() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
            System.out.println(event.source.damageType);
            System.out.println(event.source.getDamageType());
            System.out.println(player.getHeldItem());
            Minecraft.getMinecraft().thePlayer.sendChatMessage("yoo u just killed a mob gj");
            event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ,  new ItemStack(Items.diamond, 64)));
        }
    }*/

    /*@SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {

        }
    }*/

    /*@SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            if (!(Minecraft.getMinecraft().currentScreen instanceof HUDConfigScreen))
            {
                InvadersOverlayMod.instance.hudManager.renderMods();
            }
        }
    }*/

    @SubscribeEvent
    public void commandEvent(CommandEvent event)
    {
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld == null) return;
        onInput(mc);
    }

    public void onInput(Minecraft mc)
    {
        if (mc.currentScreen == null && KeybindsInit.HUD_CONFIG.isPressed())
        {
            mc.displayGuiScreen(new HUDConfigScreen());
        }
    }

    /*@SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {

    }*/

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof HUDConfigScreen)) {
            InvadersOverlayMod.instance.hudManager.renderMods();
        }
    }
}
