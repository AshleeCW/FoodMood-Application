package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
//FIXME changed exported (in AndroidManifest) to Cuisine for testing purposes. Needs changed back to Main.
        TextView t;
        @Override

    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            t = (TextView)findViewById(R.id.textView3);
            t.setOnClickListener(this);
        }

    public void onClick(View arg0) {
        Intent myintent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(myintent);
        }
    }

