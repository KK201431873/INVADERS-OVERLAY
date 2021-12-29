package KK201431873.invadersoverlaymod.hud.mod;

import KK201431873.invadersoverlaymod.hud.mod.impl.OverlayMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;

public class HudManager {

    public static int curTask;
    private static int uniqueTaskCount = 1;

    public static ArrayList<HudMod> hudMods = new ArrayList<HudMod>();

    public HudManager() {
        curTask = 0;
        hudMods.add(new OverlayMod("New Task", 75, 125));
    }

    public void renderMods()
    {
        curTask %= hudMods.size();
        hudMods.get(curTask).draw();
    }

    public static void newTask(String nm) throws CommandException {
        for (HudMod m : hudMods)
        {
            if (m.name.equalsIgnoreCase(nm))
            {
                throw new CommandException("Task name is taken");
            }
        }
        hudMods.add(new OverlayMod(nm, 75, 125));
        curTask = hudMods.size()-1;
        hudMods.get(curTask).name = nm;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("New task '" + nm + "' created"));
    }

    public static void newTask()
    {
        hudMods.add(new OverlayMod("New task " + uniqueTaskCount, 75, 125));
        uniqueTaskCount++;
        curTask = hudMods.size()-1;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("New task 'New task " + (uniqueTaskCount-1) + "' created"));
    }

    public static void deleteTask(String nm) throws CommandException
    {
        if (hudMods.size() > 1)
        {
            for (HudMod m : hudMods)
            {
                if (m.name.equalsIgnoreCase(nm))
                {
                    String delName = m.name;
                    hudMods.remove(hudMods.indexOf(m));
                    if (curTask >= hudMods.size())
                    {
                        curTask = hudMods.size()-1;
                    }
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Deleted task '" + delName + "'"));
                    return;
                }
            }
            throw new CommandException("Task does not exist");
        }
        else
        {
            throw new CommandException("Cannot delete the last task!");
        }
    }

    public static void deleteTask(int ind) throws CommandException
    {
        if (hudMods.size() > 1)
        {
            if (0 <= ind && ind < hudMods.size())
            {
                String delName = hudMods.get(ind).name;
                hudMods.remove(ind);
                if (curTask >= hudMods.size())
                {
                    curTask = hudMods.size()-1;
                }
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Deleted task '" + delName + "'"));
            }
            else
            {
                throw new CommandException("Index is out of bounds!");
            }
        }
        else
        {
            throw new CommandException("Cannot delete the last task!");
        }
    }

    public static void deleteTask() throws CommandException
    {
        if (hudMods.size() > 1)
        {
            String delName = hudMods.get(curTask).name;
            hudMods.remove(curTask);
            if (curTask >= hudMods.size())
            {
                curTask = hudMods.size()-1;
            }
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Deleted task '" + delName + "'"));
        }
        else
        {
            throw new CommandException("Cannot delete the last task!");
        }
    }

    public static void setName(String nm) throws CommandException
    {
        for (HudMod m : hudMods)
        {
            if (m.name.equalsIgnoreCase(nm))
            {
                throw new CommandException("Task name is taken");
            }
        }
        hudMods.get(curTask).name = nm;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Set current task's name to '" + nm + "'"));
    }

    public static void cycleTasksForward()
    {
        curTask = (curTask + 1) % hudMods.size();
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Switched to '" + hudMods.get(curTask).name + "'"));
    }

    public static void cycleTasksBackward()
    {
        curTask = (curTask - 1) % hudMods.size();
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Switched to '" + hudMods.get(curTask).name + "'"));
    }

    public static void setItemGoal(int itemInd, int goal)
    {
        hudMods.get(curTask).resourceGoals[itemInd] = goal;
    }

    public static void listTasks()
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Tasks:"));
        for (HudMod m : hudMods)
        {
            /*String rGoalsString = "";
            for (int i = 0; i < 12; i++)
            {
                rGoalsString += m.resourceGoals[i] + " ";
            }*/
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText((hudMods.indexOf(m) + 1) + ". " + m.name + ";"));
        }
    }
}
