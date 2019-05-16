package com.example.speakids;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Welcome extends AppCompatActivity {

    VideoView videoViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        videoViewWelcome = (VideoView) findViewById(R.id.videoViewWelcome);

        String videoPath = "android.resource://com.example.speakids/" + R.raw.welcome_video;
        MediaController mediaController = new MediaController(this);
        videoViewWelcome.setMediaController(mediaController);
        Uri uri = Uri.parse(videoPath);
        videoViewWelcome.setVideoURI(uri);
        videoViewWelcome.start();

        getSupportActionBar().setTitle("Welcome Video");
    }
}
