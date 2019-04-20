package uk.ac.yorksj.mobileapplication.foodmood;

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

        /* set so onTouch of the colour wheel image it will get the pixel*/

        Button colour = (Button)findViewById(R.id.chooseColour);
        colour.setOnTouchListener(new View.OnTouchListener(){
        TextView textview = (TextView)findViewById(R.id.moodName);
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x=0;
                int y=0;
                textview.setText("Touch coordinates : " +
                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
                ImageView imageView = ((ImageView)v);
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                int pixel = bitmap.getPixel(x,y);
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);
                return true;
            }


        });

     //   Mood mood = new Mood(//get name typed into moodName, get rgb values, and get the selected genre)
    }


}
