package KK201431873.invadersoverlaymod.commands;

import KK201431873.invadersoverlaymod.hud.mod.HudManager;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Arrays;

public class IomTaskConfigCommands extends CommandBase {

    String[] indexedItemIDs = {
            "shiny_bar", "super_ultra_sticky_glue", "support_rod", "space_sand",
            "sharpened_stone", "synthetic_thread", "slime_poop", "unidentified_material",
            "bonding_agent", "super_shiny_rock", "silicon", "gyroscope"};

    String[] indexedItemNames = {
            "Shiny Bar", "Super Ultra Sticky Glue", "Support Rod", "Space Sand",
            "Sharpened Stone", "Synthetic Thread", "Slime Poop", "Unidentified Material",
            "Bonding Agent", "Super Shiny Rock", "Silicon", "Gyroscope"};

    @Override
    public String getCommandName() {
        return "iom";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0)
        {
            throw new CommandException("Usages: \n/iom help \n/iom set <item> <amount> \n/iom setall <amount1> <amount2> <amount3>...<amount10> <amount11> <amount12> \nUse /iom help to find the order of items.");
        }
        String firstParam = args[0].toLowerCase();
        if (firstParam.equals("set"))
        {
            if (args.length != 3 || !Arrays.asList(indexedItemIDs).contains(args[1]))
            {
                throw new CommandException("Usage: /iom set <item> <amount>");
            }
            int ind = Arrays.asList(indexedItemIDs).indexOf(args[1]);
            try
            {
                int setValue = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e)
            {
                throw new CommandException("Usage: /iom set <item> <amount>");
            }
            int setVal = Integer.parseInt(args[2]);
            HudManager.setItemGoal(ind, setVal);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Set " + indexedItemNames[ind] + "'s goal to " + setVal));
        }
        else if (firstParam.equals("setall"))
        {
            if (args.length != 13)
            {
                throw new CommandException("Usage: /iom setall <amount1> <amount2> <amount3>...<amount10> <amount11> <amount12>");
            }
            for (int i = 1; i < 13; i++)
            {
                try
                {
                    int setValue = Integer.parseInt(args[i]);
                }
                catch (NumberFormatException e)
                {
                    throw new CommandException("Usage: /iom setall <amount1> <amount2> <amount3>...<amount10> <amount11> <amount12>");
                }
            }
            for (int i = 1; i < 13; i++)
            {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Set " + indexedItemNames[i-1] + "'s goal to " + args[i]));
                HudManager.setItemGoal(i-1, Integer.parseInt(args[i]));
            }
        }
        else if (firstParam.equals("help"))
        {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" +
                    EnumChatFormatting.DARK_AQUA +
                    "Available commands: \n" +
                        EnumChatFormatting.GREEN +
                        "/iom help - Shows this list\n" +
                        EnumChatFormatting.GREEN +
                        "/iom set <item> <amount> - Sets the resource goal of the specified item\n" +
                        EnumChatFormatting.GREEN +
                        "/iom setall <amount1> <amount2> <amount3>...<amount10> <amount11> <amount12> - Sets the resource goal of each item to the specified amount, respectively\n" +
                    EnumChatFormatting.DARK_AQUA +
                    "List of <item> IDs (Also the resource order for /iom setall):\n" +
                        EnumChatFormatting.GREEN +
                        Arrays.asList(indexedItemIDs)));
        }
        else
        {
            throw new CommandException("Usages: \n/iom help \n/iom set <item> <amount> \n/iom setall <amount1> <amount2> <amount3>...<amount10> <amount11> <amount12> \nUse /iom help to find the order of items.");
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
