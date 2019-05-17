package uk.ac.yorksj.mobileapplication.foodmood;

import android.graphics.Color;

/*Create a mood for the user preferences which can be loaded through the Moods section of the app*/

public class Mood {

    private String name;
    private Color color;
    private String genre;

//    Mood mood = new Mood(name, red, green, blue, genre);
    //TODO try below with the above mood too. May not need the overloaded method
    /*Convert the mood to a String so it can be converted to bytes and saved in output stream*/

    /*Overload the method to allow the single class to be converted to string*/
    public Mood(String name, int red, int green, int blue, String genre) {
        this.name = name;
        this.genre = genre;
        this.color.red(red);
        this.color.green(green);
        this.color.blue(blue);
    }

    public Mood(String name, Color color, String genre) {
        this.name = name;
        this.color = color;
        this.genre = genre;
    }

    public String returnName() {
        return this.name;
    }

    public String returnGenre() {
        return this.genre;
    }

    public Mood returnMood() {
        return this;
    }

}