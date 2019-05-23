package uk.ac.yorksj.mobileapplication.foodmood;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class MoodList {
    static public ArrayList<Mood> getFromPrefs(Activity activity) {
        ArrayList<Mood> moods = new ArrayList<>();

        SharedPreferences prefs = activity.getSharedPreferences("prefs", activity.getBaseContext().MODE_PRIVATE);
        String history = prefs.getString("history", "");
        Gson gson = new Gson();

        Log.e("history", "history is " + history);
        if (history.length() > 0) {
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(history).getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                JsonObject moodObject = (JsonObject) array.get(i);
                String name = moodObject.get("name").getAsString();
                String genre = moodObject.get("genre").getAsString();
                Integer red = moodObject.get("red").getAsInt();
                Integer green = moodObject.get("green").getAsInt();
                Integer blue = moodObject.get("blue").getAsInt();


              //Color color = moodObject.get("color").getasColor();
                /* XXX: not recovering colour yet */
                moods.add(new Mood(name, red, green, blue, genre));
            }
        }
        return moods;
    }
}
