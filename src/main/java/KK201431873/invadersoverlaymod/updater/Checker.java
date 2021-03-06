package KK201431873.invadersoverlaymod.updater;

import KK201431873.invadersoverlaymod.InvadersOverlayMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Checker {
    public void checkUpdate(){
        try {
            System.out.println("Starting update checker process.");
            /* Checks https://raw.githubusercontent.com/KK201431873/INVADERS-OVERLAY/main/src/main/resources/version.txt
            to see if it is the same string as InvadersOverlayMod.VERSION */
            URL url = new URL("https://raw.githubusercontent.com/KK201431873/INVADERS-OVERLAY/main/src/main/resources/version.txt");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            String mostUpToDateVersion = content.toString();
            System.out.println("MOST UP TO DATE VERSION:" + mostUpToDateVersion);

            if(!InvadersOverlayMod.VERSION.equals(mostUpToDateVersion)){
                System.out.println("Found update! You are running " + InvadersOverlayMod.VERSION);
                System.out.println("Please update to " + content + " at https://github.com/KK201431873/INVADERS-OVERLAY");
                System.out.println("Sending message to the player when they join a world.");

                /* Registers SendMessageOnWorldJoin
                ONLY if the mostUpToDateVersion is not the same as InvadersOverMod.VERSION */
                MinecraftForge.EVENT_BUS.register(new SendMessageOnWorldJoin(mostUpToDateVersion));

            } else {
                System.out.println("You are up to date!");
            }

            in.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
