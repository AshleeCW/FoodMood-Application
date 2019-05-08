package uk.ac.yorksj.mobileapplication.foodmood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Cuisine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);










       /* public void displayToast() {
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_SHORT).show();
        }
        public void showUSA(View view) {
            displayToast(getString(R.string.title_activity_cuisineUSA));
        }*/







/*
        imageView usa = findViewById(R.id.americanflag);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {









            }
        }); */



       // Toolbar toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
    public void displayToastMsg(android.view.View v) {

        if(v == findViewById(R.id.americanflag)) {
            toastMsg("Hello how are you today!!");
        }
        else if(v ==findViewById(R.id.frenchflag)){
          toastMsg("Poopy butthole");
        }
        else if(v ==findViewById(R.id.chinaFlag)){
            toastMsg("Coward");
        }
        else if(v ==findViewById(R.id.italyflag)){
            toastMsg("Supermario");
        }
        else if(v ==findViewById(R.id.indianflag)){
            toastMsg("hole");
        }
        else if(v ==findViewById(R.id.britishflag)){
            toastMsg("god save the queen");
        }

    }
  //      });
    //}

}
