package hypsearcher.mojang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetUUID {
    public static String getUUID(String playername) {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + playername;
        StringBuffer json = new StringBuffer();
        try {
            URL u = new URL(url);
            URLConnection yc = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputline = null;
            while ((inputline = in.readLine()) != null) {
                json.append(inputline);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!json.toString().contains("name"))
            return "";
        JsonParser parse = new JsonParser();
        JsonObject jsons = (JsonObject) parse.parse(json.toString());
        return jsons.get("id").getAsString();
    }
}
