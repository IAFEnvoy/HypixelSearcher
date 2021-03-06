package hypsearcher.hypixel.Info;

import com.google.gson.JsonObject;

import hypsearcher.hypixel.Util.GetData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RootInfo {
    public static String getRank(JsonObject player) {
        String rank = null;
        try {
            rank = player.get("newPackageRank").getAsString();
        } catch (Exception e) {
            return "";
        }
        if (rank != null)
            switch (rank) {
                case "VIP": {
                    rank = "§2[VIP]";
                    break;
                }
                case "VIP_PLUS": {
                    rank = "§2[VIP+]";
                    break;
                }
                case "MVP": {
                    rank = "§b[MVP]";
                    break;
                }
                case "MVP_PLUS": {
                    rank = "§b[MVP+]";
                    break;
                }
                case "MVP_PLUS_PLUS": {
                    rank = "§6[MVP++]";
                    break;
                }
            }
        return rank;
    }

    public static int getLevel(JsonObject player) {
        int level = 1;
        while (true) {
            try {
                player.get("levelingReward_" + String.valueOf(level)).getAsString();
                level++;
            } catch (Exception e) {
                break;
            }
        }
        return level;
    }

    public static int getGameWin(JsonObject player) {// 获取游戏总胜场
        int general_wins = 0;
        try {
            general_wins = player.get("achievements").getAsJsonObject().get("general_wins").getAsInt();
        } catch (Exception e) {
            return -1;
        }
        return general_wins;
    }

    public static int getTaskComplete(JsonObject player) {// 获取完成的任务数量
        int general_quest_master = 0;
        try {
            general_quest_master = player.get("achievements").getAsJsonObject().get("general_quest_master").getAsInt();
        } catch (Exception e) {
            return -1;
        }
        return general_quest_master;
    }

    public static int getChallengeComplete(JsonObject player) {// 获取完成的挑战数量
        int general_challenger = 0;
        try {
            general_challenger = player.get("achievements").getAsJsonObject().get("general_challenger").getAsInt();
        } catch (Exception e) {
            return -1;
        }
        return general_challenger;
    }

    public static int getCoin(JsonObject player) {// 获取硬币数量
        int general_coins = 0;
        try {
            general_coins = player.get("achievements").getAsJsonObject().get("general_coins").getAsInt();
        } catch (Exception e) {
            return -1;
        }
        return general_coins;
    }

    public static String getTime(JsonObject player, int type) {
        long time = 0;
        try {
            switch (type) {
                case 0: {
                    time = player.get("firstLogin").getAsLong();
                    break;
                }
                case 1: {
                    time = player.get("lastLogin").getAsLong();
                    break;
                }
                case 2: {
                    time = player.get("lastLogout").getAsLong();
                    break;
                }
                default:
                    time = 0;
            }
        } catch (Exception e) {
            return "ERROR";
        }
        if (time == 0)
            return "ERROR";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return sf.format(date);
    }

    public static String getRoot(JsonObject player, String playername) {
        String output = "\n";
        output += RootInfo.getRank(player) + playername + "§f的Hypixel信息\n";
        output += "等级：" + RootInfo.getLevel(player) + " | 人品值：" + String.valueOf(GetData.getKeyInt(player, "karma"))
                + "\n";
        output += "成就点数：" + String.valueOf(GetData.getKeyInt(player, "achievementPoints")) + " | 小游戏胜场："
                + RootInfo.getGameWin(player) + "\n";
        output += "完成任务：" + RootInfo.getTaskComplete(player) + " | 完成挑战：" + RootInfo.getChallengeComplete(player)
                + "\n";
        output += "获得硬币：" + RootInfo.getCoin(player) + "\n";
        output += "首次登录：" + RootInfo.getTime(player, 0) + "\n";
        output += "上次登录：" + RootInfo.getTime(player, 1) + "\n";
        output += "上次退出：" + RootInfo.getTime(player, 2) + "\n";
        output += "最后游玩：" + GetData.getKeyString(player, "mostRecentGameType") + "\n";
        return output;
    }
}
