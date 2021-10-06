package hypsearcher.hypixel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hypsearcher.mojang.GetUUID;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import hypsearcher.hypixel.Info.*;

public class GetJSON {
    public static String APIKEY = "a349c3cb-8613-4c04-9b10-565b602fa30b";
    public static String BASEURL = "https://api.hypixel.net";

    public static String getURL(String location, String... args) {
        String url = BASEURL + location + "?";
        for (String arg : args) {
            if (arg != args[0])
                url += "&";
            url += arg;
        }
        return url;
    }

    public static void overview(String playername, PlayerEntity message, int key) {
        String uuid = GetUUID.getUUID(playername);
        if (uuid.isBlank()) {
            System.out.println("玩家不存在");
            return;
        }
        String url = getURL("/player", "key=" + APIKEY, "uuid=" + uuid);
        StringBuffer json = new StringBuffer();
        try {
            // 通过url获得连接
            URL u = new URL(url);
            URLConnection yc = u.openConnection();
            // 读取返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputline = null;
            while ((inputline = in.readLine()) != null) {
                json.append(inputline);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonParser parse = new JsonParser();
        JsonObject jsons = (JsonObject) parse.parse(json.toString());
        if (!jsons.get("success").getAsBoolean()) {
            System.out.println("请求出现错误，原因：" + jsons.get("cause").getAsString());
            return;
        }
        String output;
        try {
            switch (key) {
                case 0: {
                    JsonObject player = (JsonObject) jsons.get("player");
                    output = RootInfo.getRoot(player, playername);
                    break;
                }
                case 1: {
                    JsonObject player = (JsonObject) jsons.get("player");
                    JsonObject stats = (JsonObject) player.get("stats");
                    JsonObject bedwars = (JsonObject) stats.get("Bedwars");
                    output = BedwarInfo.getBedwar(bedwars, RootInfo.getRank(player) + playername);
                    break;
                }
                case 2: {
                    JsonObject player = (JsonObject) jsons.get("player");
                    JsonObject stats = (JsonObject) player.get("stats");
                    JsonObject skywars = (JsonObject) stats.get("SkyWars");
                    output = SkywarInfo.getSkywar(skywars, RootInfo.getRank(player) + playername);
                    break;
                }
                case 3: {
                    JsonObject player = (JsonObject) jsons.get("player");
                    JsonObject stats = (JsonObject) player.get("stats");
                    JsonObject buildBattle = (JsonObject) stats.get("BuildBattle");
                    output = BuildBattleInfo.getBuildBattle(buildBattle, RootInfo.getRank(player) + playername);
                    break;
                }
                default:
                    output = "请求的键值不存在！";
            }
        } catch (Exception e) {
            e.printStackTrace();
            output = "解析出现错误";
        }
        if (message != null)
            message.sendMessage(Text.of(output), false);
        else System.out.println(output);
    }

}
