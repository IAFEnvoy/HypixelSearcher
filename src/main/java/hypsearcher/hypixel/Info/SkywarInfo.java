package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

public class SkywarInfo {
    public static String getSkywar(JsonObject skywar, String playername) {
        String output = "\n" + playername + "的空岛战争统计数据\n等级：";
        output += GetData.getKeyString(skywar, "levelFormatted") + "§f\n";
        int win = GetData.getKeyInt(skywar, "souls");
        int lose = GetData.getKeyInt(skywar, "coins");
        output += "灵魂：" + String.valueOf(win) + "|硬币：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(skywar, "games_played_skywars") - GetData.getKeyInt(skywar, "losses");
        lose = GetData.getKeyInt(skywar, "losses");
        output += "胜场：" + String.valueOf(win) + "|败场：" + String.valueOf(lose) + "\n";
        output += "上次游玩：" + GetData.getKeyString(skywar, "lastMode");
        return output;
    }
}
