package KK201431873.invadersoverlaymod;

import KK201431873.invadersoverlaymod.commands.IomShortenedTaskCommands;
import KK201431873.invadersoverlaymod.commands.IomTaskCommands;
import KK201431873.invadersoverlaymod.commands.IomTaskConfigCommands;
import KK201431873.invadersoverlaymod.hud.mod.HudManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import KK201431873.invadersoverlaymod.proxy.CommonProxy;

@Mod(modid = InvadersOverlayMod.MODID, version = InvadersOverlayMod.VERSION, name = InvadersOverlayMod.NAME)
public class InvadersOverlayMod
{
    public static final String MODID = "invadersoverlaymod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Hypixel Invaders Overlay Mod";
    Minecraft mc = Minecraft.getMinecraft();

    @SidedProxy(clientSide = "KK201431873.invadersoverlaymod.proxy.ClientProxy", serverSide = "KK201431873.invadersoverlaymod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static InvadersOverlayMod instance;

    public HudManager hudManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        KeybindsInit.register(event);
        ClientCommandHandler.instance.registerCommand(new IomTaskConfigCommands());
        ClientCommandHandler.instance.registerCommand(new IomTaskCommands());
        ClientCommandHandler.instance.registerCommand(new IomShortenedTaskCommands());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new IOMEventHandler());
        hudManager = new HudManager();
        proxy.postInit(event);
    }
}
