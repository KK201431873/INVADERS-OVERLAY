package KK201431873.invadersoverlaymod;

import KK201431873.invadersoverlaymod.commands.IomShortenedTaskCommands;
import KK201431873.invadersoverlaymod.commands.IomTaskCommands;
import KK201431873.invadersoverlaymod.commands.IomTaskConfigCommands;
import KK201431873.invadersoverlaymod.hud.mod.HudManager;
import KK201431873.invadersoverlaymod.updater.Checker;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = InvadersOverlayMod.MODID, version = InvadersOverlayMod.VERSION, name = InvadersOverlayMod.NAME)
public class InvadersOverlayMod {
    public static final String MODID = "invadersoverlaymod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Hypixel Invaders Overlay Mod";

    @Mod.Instance
    public static InvadersOverlayMod instance;

    public HudManager hudManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        KeybindsInit.register(event);
        ClientCommandHandler.instance.registerCommand(new IomTaskConfigCommands());
        ClientCommandHandler.instance.registerCommand(new IomTaskCommands());
        ClientCommandHandler.instance.registerCommand(new IomShortenedTaskCommands());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new IOMEventHandler());
        hudManager = new HudManager();
        Checker updater = new Checker();
        updater.checkUpdate(event);
    }
}
