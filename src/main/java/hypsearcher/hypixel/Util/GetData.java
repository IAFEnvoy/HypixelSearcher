package hypsearcher.hypixel.Util;

import com.google.gson.JsonObject;

public class GetData {
    public static int getKeyInt(JsonObject object, String key) {
        int data = 0;
        try {
            data = object.get(key).getAsInt();
        } catch (Exception e) {
            return 0;
        }
        return data;
    }

    public static String getKeyString(JsonObject object, String key) {
        String data = "";
        try {
            data = object.get(key).getAsString();
        } catch (Exception e) {
            return "ERROR";
        }
        return data;
    }

    public static boolean getKeyBoolean(JsonObject object, String key) {
        boolean data = false;
        try {
            data = object.get(key).getAsBoolean();
        } catch (Exception e) {
            return false;
        }
        return data;
    }
}
