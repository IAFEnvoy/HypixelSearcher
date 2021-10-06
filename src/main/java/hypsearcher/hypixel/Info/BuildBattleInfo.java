package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

public class BuildBattleInfo {
    public static String getBuildBattle(JsonObject build, String playername) {
        String output = "\n" + playername + "的建筑大师统计数据\n硬币：";
        output += String.valueOf(GetData.getKeyInt(build, "coins")) + "|总分："
                + String.valueOf(GetData.getKeyInt(build, "score")) + "\n";
        int lose = GetData.getKeyInt(build, "games_played");
        int win = GetData.getKeyInt(build, "wins");
        output += "游玩次数：" + String.valueOf(lose) + "|胜场：" + String.valueOf(win) + "\n";
        output += "猜猜乐正确的次数：" + String.valueOf(GetData.getKeyInt(build, "correct_guesses"));
        return output;
    }
}
