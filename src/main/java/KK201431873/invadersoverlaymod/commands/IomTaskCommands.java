package KK201431873.invadersoverlaymod.commands;

import KK201431873.invadersoverlaymod.hud.mod.HudManager;
import KK201431873.invadersoverlaymod.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class IomTaskCommands extends CommandBase {

    @Override
    public String getCommandName() {
        return "task";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0)
        {
            throw new CommandException("Usages: \n/task help \n/task new \n/task delete <taskName> \n/task setname <taskName>" +
                    "\n/task cycle <forward/backward> \n/task list \nNOTE: '/task' is replacable with '/t'");
        }
        String firstParam = args[0].toLowerCase();
        if (firstParam.equals("help"))
        {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" +
                            EnumChatFormatting.DARK_AQUA +
                            "Task management commands: \n" +
                                EnumChatFormatting.GREEN +
                                    "/task help - Shows this list\n" +
                                EnumChatFormatting.GREEN +
                                    "/task new <taskName> - Creates a new task with the specified name\n" +
                                EnumChatFormatting.GREEN +
                                    "/task new - Creates a new task\n" +
                                EnumChatFormatting.GREEN +
                                    "/task delete <taskName> - Deletes task with the specified name\n" +
                                EnumChatFormatting.GREEN +
                                    "/task deleteind <index> - Deletes task at the specified index\n" +
                                EnumChatFormatting.GREEN +
                                    "/task delete - Deletes current task\n" +
                                EnumChatFormatting.GREEN +
                                    "/task setname <taskName> - Sets the current task's name to the specified name\n" +
                            EnumChatFormatting.DARK_AQUA +
                            "Task viewing commands: \n" +
                                EnumChatFormatting.GREEN +
                                    "/task switch <index> - Switches to the task at the specified index\n" +
                                EnumChatFormatting.GREEN +
                                    "/task cycle <forward/backward> - Switches to the next or the previous listed task\n" +
                                EnumChatFormatting.GREEN +
                                    "/task list - Lists all existing tasks in cycling order\n" +
                            EnumChatFormatting.DARK_AQUA +
                            "Shortened commands: \n" +
                                EnumChatFormatting.GREEN +
                                    "/task del <taskName> - Shortened delete command\n" +
                                EnumChatFormatting.GREEN +
                                    "/task delind <index> - Shortened index deletion command\n" +
                                EnumChatFormatting.GREEN +
                                    "/task del - Shortened delete command (Current task)\n" +
                                EnumChatFormatting.GREEN +
                                    "/task sn <taskName> - Shortened setname command\n" +
                                EnumChatFormatting.GREEN +
                                    "/task c <f/b> - Shortened cycle command\n" +
                            EnumChatFormatting.YELLOW +
                                "NOTE: '/task' is replacable with '/t'"));
        }
        else if (firstParam.equals("new"))
        {
            if (args.length >= 2)
            {
                String taskName = "";
                for (int i = 1; i < args.length; i++)
                {
                    taskName += args[i];
                    if (i != args.length-1)
                    {
                        taskName += " ";
                    }
                }
                HudManager.newTask(taskName);
            }
            else if (args.length == 1)
            {
                HudManager.newTask();
            }
            else
            {
                throw new CommandException("Usage: /task new <taskName> OR /task new");
            }
        }
        else if (firstParam.equals("delete") || firstParam.equals("del"))
        {
            if (args.length >= 2)
            {
                String taskName = "";
                for (int i = 1; i < args.length; i++)
                {
                    taskName += args[i];
                    if (i != args.length-1)
                    {
                        taskName += " ";
                    }
                }
                HudManager.deleteTask(taskName);
            }
            else if (args.length == 1)
            {
                HudManager.deleteTask();
            }
            else
            {
                throw new CommandException("Usage: /task delete <taskName> OR /task delete \n/task del <taskName> OR /task del");
            }
        }
        else if (firstParam.equals("deleteind") || firstParam.equals("delind"))
        {
            if (args.length == 2)
            {
                HudManager.deleteTask(Integer.parseInt(args[1])-1);
            }
            else
            {
                throw new CommandException("Usage: /task deleteind <index> OR /task delind <index>");
            }
        }
        else if (firstParam.equals("setname") || firstParam.equals("sn"))
        {
            if (args.length >= 2)
            {
                String taskName = "";
                for (int i = 1; i < args.length; i++)
                {
                    taskName += args[i];
                    if (i != args.length-1)
                    {
                        taskName += " ";
                    }
                }
                HudManager.setName(taskName);
            }
            else
            {
                throw new CommandException("Usage: /task setname <taskName> OR /task sn <taskName>");
            }
        }
        else if (firstParam.equals("cycle") || firstParam.equals("c"))
        {
            if (args.length == 2)
            {
                if (args[1].equalsIgnoreCase("forward") || args[1].equalsIgnoreCase("f"))
                {
                    HudManager.cycleTasksForward();
                }
                else if (args[1].equalsIgnoreCase("backward") || args[1].equalsIgnoreCase("b"))
                {
                    HudManager.cycleTasksBackward();
                }
                else
                {
                    throw new CommandException("Usage: /task cycle <forward/backward OR f/b> OR /task c <forward/backward OR f/b>");
                }
            }
            else
            {
                throw new CommandException("Usage: /task cycle <forward/backward OR f/b> OR /task c <forward/backward OR f/b>");
            }
        }
        else if (firstParam.equals("list"))
        {
            HudManager.listTasks();
        }
        else
        {
            throw new CommandException("Usages: \n/task help \n/task new \n/task delete <taskName> \n/task setname <taskName>" +
                    "\n/task cycle <forward/backward> \n/task list \nNOTE: '/task' is replacable with '/t'");
        }
    }
}
