package KK201431873.invadersoverlaymod.updater;

import KK201431873.invadersoverlaymod.InvadersOverlayMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class SendMessageOnWorldJoin {
    String versionToUpdate;

    public SendMessageOnWorldJoin(String mostUpToDateVersion) {
        this.versionToUpdate = mostUpToDateVersion;
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "-------------"));
        player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "You are running IOM on version " + InvadersOverlayMod.VERSION));
        player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Please update to version " + versionToUpdate));
        player.addChatComponentMessage(new ChatComponentText("https://github.com/KK201431873/INVADERS-OVERLAY/releases"));
        player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.BLUE + "-------------"));
    }
}
