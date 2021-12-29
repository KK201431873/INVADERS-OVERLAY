package KK201431873.invadersoverlaymod;

import KK201431873.invadersoverlaymod.events.KeyPressedEvent;
import KK201431873.invadersoverlaymod.events.RenderOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class IOMEventHandler {
    //Register events here
    public void init(){
        MinecraftForge.EVENT_BUS.register(new KeyPressedEvent());
        MinecraftForge.EVENT_BUS.register(new RenderOverlayEvent());
    }

    /*
    @SubscribeEvent
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
    }

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {

        }
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            if (!(Minecraft.getMinecraft().currentScreen instanceof HUDConfigScreen))
            {
                InvadersOverlayMod.instance.hudManager.renderMods();
            }
        }
    }

    */
}
