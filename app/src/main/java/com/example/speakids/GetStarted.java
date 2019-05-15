package com.example.speakids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.speakids.utils.MenuGetStarted;

public class GetStarted extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        CustomListAdapter whatever = new CustomListAdapter(this, MenuGetStarted.NAME_ARRAY,
                MenuGetStarted.INFO_ARRAY, MenuGetStarted.IMAGE_ARRAY);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String itemName = MenuGetStarted.NAME_ARRAY[position];
                startActivity(new Intent(getApplicationContext(),
                        DetailActivity.class).putExtra("itemName", itemName));
            }
        });

        getSupportActionBar().setTitle("Get Started");
    }
}
