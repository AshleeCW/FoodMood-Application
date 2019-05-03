package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.ArrayList;


public class PreferencesActivity extends AppCompatActivity {

    String moodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences2);

        /* set so onTouch of the colour wheel image it will get the pixel*/

      //  Button colour = (Button)findViewById(R.id.chooseColour);
        ArrayList<ImageView> genres = createList();
        Mood temp;
        TextView mood_name = findViewById(R.id.mood_name);
        int redValue = 255;
        int greenValue = 255;
        int blueValue = 255;
       // String genre = genreSelector();

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView mood_name = findViewById(R.id.mood_name);
                String name = mood_name.getText().toString();
                int redValue = 255;
                int greenValue = 255;
                int blueValue = 255;
                String genre = "Pop";

                Mood mood = new Mood(name, redValue, greenValue, blueValue, genre);
                Gson gson = new Gson();
                String userMoodToJsonString = gson.toJson(mood);
                /*here use gson to convert java class to json string to retrieve
                the object back again *dabs*/

                SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("mood", userMoodToJsonString); //no errors dabbing here

                //TODO add other files to mood || add the complete mood rather than each line
                editor.commit();
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
                System.out.println(moodName);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, moodName, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


    }

    public String genreSelector(ImageButton genreImage){
        String genreOne = "Metal";
        String genreTwo = "Pop";
        String genreThree = "Indie";
        String genreFour = "Classical";

        if(genreImage == genreImage.findViewById(R.id.genreOne)){
            return genreOne;
        }else if(genreImage == genreImage.findViewById(R.id.genreTwo)) {
            return genreTwo;
        }else if(genreImage == genreImage.findViewById(R.id.genreThree)) {
            return genreThree;
        }else if(genreImage == genreImage.findViewById(R.id.genreFour)) {
            return genreFour;
        }


            return "text";
    }
    public ArrayList<ImageView> createList(){
        ArrayList<ImageView> genreList = new ArrayList<ImageView>();
        ImageView genreOne = findViewById(R.id.genreOne);
        ImageView genreTwo = findViewById(R.id.genreTwo);
        ImageView genreThree = findViewById(R.id.genreThree);
        ImageView genreFour = findViewById(R.id.genreFour);
        genreList.add(genreOne);
        genreList.add(genreTwo);
        genreList.add(genreThree);
        genreList.add(genreFour);
        return genreList;
    }

}
