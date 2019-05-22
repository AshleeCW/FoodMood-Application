package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.prefs.Preferences;


public class PreferencesActivity extends AppCompatActivity {

    String moodName;
    String moodGenre;
    int redValue = 100; //100 is the default progress on sliders
    int greenValue = 100;
    int blueValue = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences2);

        /* set so onTouch of the colour wheel image it will get the pixel*/

      //  Button colour = (Button)findViewById(R.id.chooseColour);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);
        View colorPreview = findViewById(R.id.colorPreview);
        View root = colorPreview.getRootView();
        root.setBackgroundColor(Color.rgb(137, 211, 255));
        colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));


        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            View colorPreview = findViewById(R.id.colorPreview);


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                redValue = progress;
                View colorPreview = findViewById(R.id.colorPreview);
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));


            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                //changes
            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View colorPreview = findViewById(R.id.colorPreview);

                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                greenValue = progress;
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                View colorPreview = findViewById(R.id.colorPreview);

                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }
        });
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View colorPreview = findViewById(R.id.colorPreview);

                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                blueValue = progress;
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                View colorPreview = findViewById(R.id.colorPreview);

                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }
        });

        Button save = findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextView mood_name = findViewById(R.id.mood_name);
                String name = mood_name.getText().toString();

                ArrayList<Mood> moods = MoodList.getFromPrefs(PreferencesActivity.this);
                Mood mood = new Mood(name, redValue, greenValue, blueValue, genreSelector(view));
                moods.add(mood);
                Gson gson = new Gson();
//                String userMoodToJsonString = gson.toJson(mood);
                String moodHistoryListToString = gson.toJson(moods); //use this in the shsredprefs
                /*here use gson to convert java class to json string to retrieve
                the object back again *dabs*/

                SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
     //           editor.putString("mood", userMoodToJsonString); //no errors dabbing here
                editor.putString("history", moodHistoryListToString);
                Log.e("history", "writing " + moodHistoryListToString);


                Intent moodPage = new Intent(view.getContext(), MoodsActivity.class);
                startActivity(moodPage);



                //TODO add other files to mood || add the complete mood rather than each line
                editor.apply();
                //if this causes issues change back to editor.commit() , Android Studio recommended .apply()
                //editor.apply();//change to commit if error here
            }
        });

        Button load = findViewById(R.id.load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getPreferences(getBaseContext().MODE_PRIVATE);
                String mood = prefs.getString("mood", "DEFAULT");

                Gson gson = new Gson();
                Mood userMadeMood = gson.fromJson(mood, Mood.class);
                moodName = userMadeMood.getName();
                moodGenre = userMadeMood.getGenre();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, moodGenre, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //ToolBar code
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),home.class));
//            }
//        });
        ImageButton homeBut = findViewById(R.id.homeBut);
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });


    }

    public String genreSelector(View view){
        RadioGroup genreRadioGroup = findViewById(R.id.genreRadioGroup);
        switch (genreRadioGroup.getCheckedRadioButtonId()){
            case R.id.radio_heavy_metal:
                Toast.makeText(this,"Heavy Metal", Toast.LENGTH_SHORT).show();
                return "Heavy Metal";
            case R.id.radio_pop:
                Toast.makeText(this,"Pop", Toast.LENGTH_SHORT).show();

                return "Pop";
            case R.id.radio_indie:
                Toast.makeText(this,"Indie", Toast.LENGTH_SHORT).show();

                return "Indie";
            case R.id.radio_classical:
                Toast.makeText(this,"Classical", Toast.LENGTH_SHORT).show();

                return "Classical";
        }
        return "No genre selected";
    }

    public ArrayList<Mood> makeHistory(ArrayList<Mood> moods, Mood additionalMood){
        moods.add(additionalMood);
        return moods;
    }


}
