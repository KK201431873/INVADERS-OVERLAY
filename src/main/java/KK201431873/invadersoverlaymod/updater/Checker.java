package KK201431873.invadersoverlaymod.updater;

import KK201431873.invadersoverlaymod.InvadersOverlayMod;
import org.lwjgl.Sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Checker {
    public void checkUpdate(){
        try {
            System.out.println("Starting update checker process.");
            //TODO: Change the url to https://raw.githubusercontent.com/KK201431873/INVADERS-OVERLAY/ressources/version.txt
            // or the equivalent of the raw version.txt
            URL url = new URL("https://raw.githubusercontent.com/portalthree/Botcraft/master/CMakeLists.txt");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println("MOST UP TO DATE VERSION: " + content);

            if(!InvadersOverlayMod.MODID.equals(content.toString())){
                System.out.println("Found update! You are running " + InvadersOverlayMod.VERSION);
                System.out.println("Please update to " + content + " at https://github.com/KK201431873/INVADERS-OVERLAY");
                System.out.println("Sending message to the player when they join a world.");

                //TODO: Send a message to the player to notify them to update.
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
