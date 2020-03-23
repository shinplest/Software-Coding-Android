package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("액티비티 생명주기", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("액티비티 생명주기", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("액티비티 생명주기", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("액티비티 생명주기", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("액티비티 생명주기", "onStop");
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("액티비티 생명주기", "onDestroy");
    }
}