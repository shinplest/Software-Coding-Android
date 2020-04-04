package com.shinplest.navermapproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        if(mapFragment == null){
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setMapType(NaverMap.MapType.Basic);
//        naverMap.setMapType(NaverMap.MapType.Terrain);
//        naverMap.setMapType(NaverMap.MapType.Satellite);
//        naverMap.setMapType(NaverMap.MapType.Terrain);
//        naverMap.setMapType(NaverMap.MapType.Navi);
    }
}