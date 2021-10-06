package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

public class BedwarInfo {
    public static String getBedwar(JsonObject bedwars, String playername) {
        String output = "\n" + playername + "的起床战争统计数据\n硬币：";
        output += String.valueOf(GetData.getKeyInt(bedwars, "coins")) + "\n";
        int win = GetData.getKeyInt(bedwars, "wins_bedwars");
        int lose = GetData.getKeyInt(bedwars, "losses_bedwars");
        output += "胜场：" + String.valueOf(win) + "|败场：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(bedwars, "beds_broken_bedwars");
        lose = GetData.getKeyInt(bedwars, "beds_lost_bedwars");
        output += "拆床：" + String.valueOf(win) + "|被拆床：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(bedwars, "kills_bedwars");
        lose = GetData.getKeyInt(bedwars, "deaths_bedwars");
        output += "击杀：" + String.valueOf(win) + "|死亡：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(bedwars, "final_kills_bedwars");
        lose = GetData.getKeyInt(bedwars, "final_deaths_bedwars");
        output += "最终击杀：" + String.valueOf(win) + "|最终死亡：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(bedwars, "iron_resources_collected_bedwars");
        lose = GetData.getKeyInt(bedwars, "gold_resources_collected_bedwars");
        output += "铁锭收集：" + String.valueOf(win) + "|金锭收集：" + String.valueOf(lose) + "\n";
        win = GetData.getKeyInt(bedwars, "emerald_resources_collected_bedwars");
        lose = GetData.getKeyInt(bedwars, "diamond_resources_collected_bedwars");
        output += "绿宝石收集：" + String.valueOf(win) + "|钻石收集：" + String.valueOf(lose) + "\n";
        return output;
    }
}
