package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;

import java.io.FileOutputStream;
/*Create a mood for the user preferences*/
public class Mood {


    private String name;
    private int red;
    private int green;
    private int blue;
    private String genre;

    Mood mood = new Mood(name, red, green, blue, genre);
    //TODO try below with the above mood too. May not need the overloaded method
    String moodString = this.toString();
    /*Convert the mood to a String so it can be converted to bytes and saved in output stream*/

    /*Overload the method to allow the single class to be converted to string*/
    public Mood(String name, int red, int green, int blue, String genre){
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.genre = genre;
    }

    public Mood(String name, int red, int green, int blue, String genre, Context context){
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.genre = genre;
        saveMood(name, context);
    }

    public Mood returnMood(){
        return this;
    }

    public void saveMood(String filename, Context context){
    FileOutputStream outputStream;

    try {
        outputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
        outputStream.write(this.moodString.getBytes());
        outputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
