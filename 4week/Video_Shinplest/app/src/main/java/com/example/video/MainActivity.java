package com.example.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoview = (VideoView) findViewById(R.id.videoview);

        videoview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.fountain_night);

        MediaController myController = new MediaController(this);

        myController.setAnchorView(videoview);

        videoview.setMediaController(myController);

        videoview.start();

        videoview.setVisibility(View.VISIBLE);
    }
}
