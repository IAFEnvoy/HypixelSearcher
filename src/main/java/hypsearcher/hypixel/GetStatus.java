package hypsearcher.hypixel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import hypsearcher.hypixel.Info.StatusInfo;
import hypsearcher.mojang.GetUUID;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetStatus {
    public static void get(String playername,PlayerEntity message){
        String uuid = GetUUID.getUUID(playername);
        if (uuid.equals("")) {
            System.out.println("玩家不存在");
            return;
        }
        String url = GetJSON.getURL("/status", "key=" + GetJSON.APIKEY, "uuid=" + uuid);
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
            JsonObject session = (JsonObject) jsons.get("session");
            output = StatusInfo.GetStatus(session, playername + "§f");
        } catch (Exception e) {
            e.printStackTrace();
            output = "解析出现错误";
        }
        if (message != null)
            message.sendMessage(Text.of(output), false);
        else
            System.out.println(output);
    }
}
