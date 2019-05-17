package com.example.speakids;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

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
    MediaPlayer dance, play, run, sing, sleep;
    String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        itemName = getIntent().getStringExtra("itemName");

        createAdapterBasedOnItemName();

        listView = (ListView) findViewById(R.id.listviewDetail);
        listView.setAdapter(whatever);

        createMediaPlayerBasedOnAudio();

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                startProcessAudio(position);
            }
        });
    }

    public void createAdapterBasedOnItemName(){
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
    }

    public void createMediaPlayerBasedOnAudio(){
        dance = MediaPlayer.create(this,R.raw.dance);
        play = MediaPlayer.create(this,R.raw.play);
        /*run = MediaPlayer.create(this,R.raw.run);
        sing = MediaPlayer.create(this,R.raw.sing);
        sleep = MediaPlayer.create(this,R.raw.sleep);*/
    }

    public void startProcessAudio(int position){
        switch (itemName){
            case "Actions":
                String subitemName = Actions.NAME_ARRAY[position];
                playAudio(subitemName);
                break;
            default:
                break;
        }
    }

    public void playAudio(String subitemName){
        switch (subitemName){
            case "Dance":
                dance.start();
                break;
            case "Play":
                play.start();
                break;
            /*case "Run":
                run.start();
                break;
            case "Sing":
                sing.start();
                break;
            case "Sleep":
                sleep.start();
                break;*/
            default:
                break;
        }
    }
}
