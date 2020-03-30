package com.example.roulettegame;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_roulette;
    float startDegree = 0;
    float endDegree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_roulette = findViewById(R.id.roulette);
        iv_roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate();
            }
        });
    }

    public void rotate() {
        startDegree = endDegree;

        Random rand = new Random();
        int degree_rand = rand.nextInt(360);
        endDegree = startDegree + 360 * 10 + degree_rand;

        ObjectAnimator object = ObjectAnimator.ofFloat(iv_roulette, "rotation", startDegree, endDegree);
        object.setInterpolator(new AccelerateDecelerateInterpolator());
        object.setDuration(3000);
        object.start();
    }
}
