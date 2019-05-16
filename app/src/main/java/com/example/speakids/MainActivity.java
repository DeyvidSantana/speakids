package com.example.speakids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Actions","Actions","Animals","Countries","Fruits","House Items","School","Seansons"};

    String[] infoArray = {
            "Ações",
            "Ações",
            "Animais",
            "Países",
            "Frutas",
            "Itens de Casa",
            "Escola",
            "Tempo"
    };

    Integer[] imageArray = {R.drawable.actions_icon,
            R.drawable.actions_icon,
            R.drawable.animals_icon,
            R.drawable.countries_icon,
            R.drawable.fruits_icon,
            R.drawable.house_items,
            R.drawable.school_icon,
            R.drawable.seasons_icon};

    ListView listView;

    ImageButton welcome;
    ImageButton getStarted;
    ImageButton yourStudies;
    ImageButton aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (ImageButton) findViewById(R.id.welcome);
        getStarted = (ImageButton) findViewById(R.id.getStarted);
        yourStudies = (ImageButton) findViewById(R.id.yourStudies);
        aboutUs = (ImageButton) findViewById(R.id.aboutUs);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Welcome.class));
            }
        });

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GetStarted.class));
            }
        });

        yourStudies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Your Studies works!",Toast.LENGTH_LONG).show();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"About Us works!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
