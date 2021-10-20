package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

public class StatusInfo {
    public static String GetStatus(JsonObject session, String playername) {
        String output = "\n" + playername + "的当前状态：";
        boolean online = GetData.getKeyBoolean(session, "online");
        if (online) {
            output += "在线\n";
            output += "当前游玩：" + GetData.getKeyString(session, "gameType");
            output += "\n模式：" + GetData.getKeyString(session, "mode");
            output += "\n地图：" + GetData.getKeyString(session, "map");
        } else {
            output += "离线";
        }
        return output;
    }
}
