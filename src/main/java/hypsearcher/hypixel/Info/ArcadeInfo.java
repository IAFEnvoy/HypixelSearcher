package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

public class ArcadeInfo {
    public static String getArcadeInfo(JsonObject arcade, String playername) {
        String output = "\n" + playername + "的街机游戏统计数据\n硬币：";
        output+=String.valueOf(GetData.getKeyInt(arcade, "coins"));
        return output;
    }
}
