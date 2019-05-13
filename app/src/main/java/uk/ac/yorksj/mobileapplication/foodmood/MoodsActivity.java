package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        int buttonId = R.id.preferencePage;
        View v = findViewById(buttonId);

        Button preferenceButton = (Button) v;

        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferencesPage = new Intent(view.getContext(), PreferencesActivity.class);
                startActivity(preferencesPage);
            }
        });
    }
}

