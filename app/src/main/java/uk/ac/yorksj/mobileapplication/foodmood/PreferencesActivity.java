package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;

public class PreferencesActivity extends AppCompatActivity {

    String moodName;
    String moodGenre;
    int redValue = 255;
    int greenValue = 255;
    int blueValue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences2);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            View colorPreview = findViewById(R.id.colorPreview);

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                redValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }
        });
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            View colorPreview = findViewById(R.id.colorPreview);

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                greenValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }
        });
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            View colorPreview = findViewById(R.id.colorPreview);

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

                blueValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                colorPreview.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            }
        });

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView mood_name = findViewById(R.id.mood_name);
                String name = mood_name.getText().toString();

                Mood mood = new Mood(name, redValue, greenValue, blueValue, genreSelector(view));
                Gson gson = new Gson();
                String userMoodToJsonString = gson.toJson(mood);
                /*here use gson to convert java class to json string to retrieve
                the object back again *dabs*/

                SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("mood", userMoodToJsonString); //no errors dabbing here

                //TODO add other files to mood || add the complete mood rather than each line
                editor.apply();
                //if this causes issues change back to editor.commit() , Android Studio recommended .apply()
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
                moodName = userMadeMood.returnName();
                moodGenre = userMadeMood.returnGenre();
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
    }

    public String genreSelector(View view){
        RadioGroup genreRadioGroup = findViewById(R.id.genreRadioGroup);
        switch (genreRadioGroup.getCheckedRadioButtonId()){
            case R.id.radio_heavy_metal:
                Toast.makeText(this,"Heavy Metal", Toast.LENGTH_SHORT).show();
                return "Heavy Metal";
            case R.id.radio_pop:
                return "Pop";
            case R.id.radio_indie:
                return "Indie";
            case R.id.radio_classical:
                return "Classical";
        }
        return "No genre selected";
    }

}
