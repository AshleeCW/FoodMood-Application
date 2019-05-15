package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        int buttonId = R.id.preferencePage;

        SharedPreferences prefs = getPreferences(getBaseContext().MODE_PRIVATE);
        String history = prefs.getString("history", "DEFAULT");

        Gson gson = new Gson();
        ArrayList<Mood> historyList = gson.fromJson(history, ArrayList.class);

        RecyclerView recycle = findViewById(R.id.moodList);
        for (int i = 0; i < historyList.size(); i++) {
         //   recycle.addView(new TextView(historyList.get(i).getName()));

        }


        View v = findViewById(buttonId);

        Button preferenceButton = (Button) v;

        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferencesPage = new Intent(view.getContext(), PreferencesActivity.class);
                startActivity(preferencesPage);
            }
        });
    }
}

