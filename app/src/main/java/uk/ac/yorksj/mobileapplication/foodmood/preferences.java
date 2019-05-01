package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class preferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }
        /* set so onTouch of the colour wheel image it will get the pixel*/
/*
        Button colour = (Button)findViewById(R.id.chooseColour);

        TextView mood_name = (TextView)findViewById(R.id.moodName);
        int redValue = 255;
        int greenValue = 255;
        int blueValue = 255;
        String genre = "Pop";
        final Mood mood = new Mood(mood_name.toString(), redValue, greenValue, blueValue, genre);
//        colour.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int x=0;
//                int y=0;
////                mood_name.setText("Touch coordinates : " +
////                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
//                ImageView imageView = ((ImageView)v);
//                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
//                int pixel = bitmap.getPixel(x,y);
//                redValue = Color.red(pixel);
//                blueValue = Color.blue(pixel);
//                greenValue = Color.green(pixel);
//                return true;
//            }
//
//            //idea is to create a mood here based on the entered variables and then can return it to preferences and save it as ".toString"
//        });

        Button save = (Button)findViewById(R.id.save);
        save.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("mood", mood.toString());
                //TODO add other files to mood || add the complete mood rather than each line
                editor.commit();
                return true;
            }


        });

        //   Mood mood = new Mood(//get name typed into moodName, get rgb values, and get the selected genre)
    }

*/

}
