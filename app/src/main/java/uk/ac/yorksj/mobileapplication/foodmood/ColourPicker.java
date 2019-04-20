package uk.ac.yorksj.mobileapplication.foodmood;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.widget.TextView;

public class ColourPicker {

    int red;
    int green;
    int blue;

    public ColourPicker(TextView text){

    }

    public ColourPicker(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public Color colourMaker(){
        Color color = new Color();
        return null;
    }
}
