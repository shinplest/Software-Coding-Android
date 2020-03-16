package com.shinplest.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        mp = MediaPlayer.create(this, R.raw.avengers);
//        mp.setLooping(false);
//        mp.start();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mp = MediaPlayer.create(this, R.raw.avengers);
        mp.setLooping(false);
        mp.seekTo(length);
        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp.isPlaying()) {
            mp.pause();
            length = mp.getCurrentPosition();
            mp.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()) {
            mp.pause();
            length = mp.getCurrentPosition();
            mp.release();
        }
    }

}
