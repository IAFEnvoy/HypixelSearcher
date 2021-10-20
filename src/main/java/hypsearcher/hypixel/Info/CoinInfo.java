package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

public class CoinInfo {
    public static String getCoinInfo(JsonObject stats, String playername) {
        String output = "\n" + playername + "所有游戏的硬币数量统计\n";
        output += "起床战争：" + getKey(stats, "Bedwars") + " | ";
        output += "决斗游戏：" + getKey(stats, "Duels") + "\n";
        output += "空岛战争：" + getKey(stats, "SkyWars") + " | ";
        output += "建筑大师：" + getKey(stats, "BuildBattle") + "\n";
        output += "街机游戏：" + getKey(stats, "Arcade") + " | ";
        output += "极限生存冠军：" + getKey(stats, "UHC") + "\n";
        output += "TNT游戏：" + getKey(stats, "TNTGames") + " | ";
        output += "*饥饿游戏：" + getKey(stats, "HungerGames") + "\n";
        output += "*掘战游戏：" + getKey(stats, "Battleground") + " | ";
        output += "MCGO：" + getKey(stats, "MCGO") + "\n";
        output += "Walls3：" + getKey(stats, "Walls3") + " | ";
        output += "SuperSmash：" + getKey(stats, "SuperSmash") + "\n";
        output += "Arena：" + getKey(stats, "Arena") + " | ";
        output += "GingerBread：" + getKey(stats, "GingerBread") + "\n";
        output += "Paintball：" + getKey(stats, "Paintball") + " | ";
        output += "Quake：" + getKey(stats, "Quake") + "\n";
        output += "VampireZ：" + getKey(stats, "VampireZ") + " | ";
        output += "Walls：" + getKey(stats, "Walls");
        return output;
    }

    public static String getKey(JsonObject object, String key) {
        int data = 0;
        try {
            JsonObject game = (JsonObject) object.get(key);
            data = game.get("coins").getAsInt();
        } catch (Exception e) {
            return "-1";
        }
        return String.valueOf(data);
    }
}
