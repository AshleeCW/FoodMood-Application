package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;
import java.util.ArrayList;


public class MoodsActivity extends AppCompatActivity {

    RecyclerView rView;
    RecycleViewAdapter rAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        rView = findViewById(R.id.moodlistView);
        rAdapt = new RecycleViewAdapter();
        rView.setAdapter(rAdapt);
        rView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        int buttonId = R.id.preferencePage;

        ArrayList<Mood> moods = MoodList.getFromPrefs(this);

        for (int i = 0; i < moods.size(); i++) {
            rAdapt.addStuff(moods.get(i).getName(), moods.get(i).getGenre(), moods.get(i).getRed(), moods.get(i).getGreen(), moods.get(i).getBlue());
            System.out.print(moods.size());
        }


        Button preferenceButton = findViewById(buttonId);

        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferencesPage = new Intent(view.getContext(), PreferencesActivity.class);
                startActivity(preferencesPage);
            }
        });

    }

    protected void onResume() {
        super.onResume();
        Log.e("history", "hello world");
        /* XXX: bit of a hack; try to update the moods list when we go back to this activity after adding a mood */
        rAdapt.notifyDataSetChanged();
    }
}
