package uk.ac.yorksj.mobileapplication.foodmood;

import android.graphics.Color;

/*Create a mood for the user preferences which can be loaded through the Moods section of the app*/

public class Mood {

    private String name;
    private String genre;
    private int red;
    private int green;
    private int blue;

//    Mood mood = new Mood(name, red, green, blue, genre);
    //TODO try below with the above mood too. May not need the overloaded method
    /*Convert the mood to a String so it can be converted to bytes and saved in output stream*/

    /*Overload the method to allow the single class to be converted to string*/
    public Mood(String name, int red, int green, int blue, String genre) {
        this.name = name;
        this.genre = genre;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getName() {
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

}