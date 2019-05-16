package com.example.speakids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.speakids.utils.Actions;
import com.example.speakids.utils.Animals;
import com.example.speakids.utils.Countries;
import com.example.speakids.utils.Fruits;
import com.example.speakids.utils.HouseItems;
import com.example.speakids.utils.School;
import com.example.speakids.utils.Seasons;

public class DetailActivity extends AppCompatActivity {

    ListView listView;
    CustomListDetailAdapter whatever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String itemName = getIntent().getStringExtra("itemName");

        if(itemName.contains("Actions")){
            whatever = new CustomListDetailAdapter(this,
                    Actions.NAME_ARRAY, Actions.INFO_ARRAY, Actions.IMAGE_ARRAY);
            getSupportActionBar().setTitle("Actions");
        }
        if(itemName.contains("Animals")){
            whatever = new CustomListDetailAdapter(this,
                    Animals.NAME_ARRAY, Animals.INFO_ARRAY, Animals.IMAGE_ARRAY);
            getSupportActionBar().setTitle("Animals");
        }
        if(itemName.contains("Countries")){
            whatever = new CustomListDetailAdapter(this,
                    Countries.NAME_ARRAY, Countries.INFO_ARRAY, Countries.IMAGE_ARRAY);
            getSupportActionBar().setTitle("Countries");
        }
        if(itemName.contains("Fruits")){
            whatever = new CustomListDetailAdapter(this,
                    Fruits.NAME_ARRAY, Fruits.INFO_ARRAY, Fruits.IMAGE_ARRAY);
            getSupportActionBar().setTitle("Fruits");
        }
        if(itemName.contains("House Items")){
            whatever = new CustomListDetailAdapter(this,
                    HouseItems.NAME_ARRAY, HouseItems.INFO_ARRAY, HouseItems.IMAGE_ARRAY);
            getSupportActionBar().setTitle("House Items");
        }
        if(itemName.contains("School")){
            whatever = new CustomListDetailAdapter(this,
                    School.NAME_ARRAY, School.INFO_ARRAY, School.IMAGE_ARRAY);
            getSupportActionBar().setTitle("School");
        }
        if(itemName.contains("Seasons")){
            whatever = new CustomListDetailAdapter(this,
                    Seasons.NAME_ARRAY, Seasons.INFO_ARRAY, Seasons.IMAGE_ARRAY);
            getSupportActionBar().setTitle("Seasons");
        }

        listView = (ListView) findViewById(R.id.listviewDetail);
        listView.setAdapter(whatever);
    }
}
