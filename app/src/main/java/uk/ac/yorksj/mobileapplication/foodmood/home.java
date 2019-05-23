package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView = findViewById(R.id.moodView1);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodPage = new Intent(view.getContext(), MoodsActivity.class);
                startActivity(moodPage);
            }
        });

        ImageView imageView1 = findViewById(R.id.cuisineView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cuisinePage = new Intent(view.getContext(), SignupActivity.class);  //THIS NEEDS CHANGING BACK TO CUISINE
                startActivity(cuisinePage);
            }
        });

        ImageView imageView2 = findViewById(R.id.cameraView1);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cuisinePage = new Intent(view.getContext(), Camera.class);
                startActivity(cuisinePage);
            }

        });

    }
}
