package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;

import java.io.FileOutputStream;

public class Mood {


    private String name;
    private int red;
    private int green;
    private int blue;
    private String genre;

    public Mood(String name, int red, int green, int blue, String genre, Context context){
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.genre = genre;
        saveMood(name, context);
    }

    public void saveMood(String filename, Context context){
    FileOutputStream outputStream;

    try {
        outputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
      //  outputStream.write(.getBytes());
        outputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
