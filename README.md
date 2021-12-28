
# INVADERS-OVERLAY
INVADERS OVERLAY MOD v1.0
Minecraft Version: Forge 1.8.9
12/28/21

Invaders Overlay Mod (IOM) is an overlay mod for Hypixel Invaders (mc.hypixel.net).
Created by KK201431873

## DOCUMENTATION

### SECTION I: GUI and Keybinds
The initial GUI shows a HUD with twelve item counters, all contained within a box (This is called a "task").
Each icon and its number displays the count of that resource present inside the player's inventory. The count also has a resource goal, displayed to the right of the inventory item count (Given "10/86", 10 would be the inventory item count and 86 would be the resource goal).
The resource counter text will appear to be red if the resource goal is not met (inventory count < resource goal) and will appear to be green when it is met (inventory count >= resource goal).
The task's HUD can be repositioned on the screen by opening the configuration screen; it is opened by pressing its keybind (defaultly RSHIFT) and the keybind can be changed by opening the Game Settings (Escape -> Options -> Controls -> "Invaders Overlay Mod" -> "Open HUD Configuration")

### SECTION II: Commands
Tasks can be configured by using the IOM commands. Execute "/iom help" in the game for a detailed list.
- /iom help - Displays the help list
- /iom set <item> <amount> - Changes the resource goal of the given item to the given amount
- /iom setall <amount1> <amount2> <amount3> <amount4> <amount5> <amount6> <amount7> <amount8> <amount9> <amount10> <amount11> <amount12>
 - Changes the resource goal of each item to their respective positions in the command.

The order is as follows:
- shiny_bar
- super_ultra_sticky_glue
- support_rod
- space_sand
- sharpened_stone
- synthetic_thread
- slime_poop
- unidentified_material
- bonding_agent
- super_shiny_rock
- silicon
- gyroscope

Tasks can be created, edited, and viewed by using the Task commands. Execute "/task help" in the game for a detailed list.
NOTE: The "/task" prefix of the command can be shortened and replaced with "/t".
- /task help		 - Displays the help list
- /task list		 - Lists all existing tasks in cycling order
- /task new <taskName>	 - Creates a new task with the given name
- /task new		 - Generates a new task
- /task delete <taskName>	 - Deletes the specified task
- /task deleteind <index>	 - Deletes the task at the given index
- /task delete		 - Deletes the current task
- /task setname <taskName> - Sets the name of the current task to the given name

Task switching (Changing to a different saved task configuration)
- /task switch <index>	 - Switches to the task at the given index
- /task cycle forward	 - Switches to the next ordered task
- /task cycle backward	 - Switches to the previous ordered task

**<taskName> CAN have multiple space-separated words.
**Indexes of tasks begin at index 1

Shorthand Substitutions
- delete		 = del
- deleteind	 = delind
- setname		 = sn
- cycle		 = c
- forward		 = f
- backward	 = b
