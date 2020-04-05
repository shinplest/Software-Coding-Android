package com.shinplest.navermapproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
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

        naverMap.setSymbolScale(1.5f);

        // 각 지점의 위도, 경도
        LatLng latlng1 = new LatLng(37.518012, 127.101966);
        LatLng latlng2 = new LatLng(37.511177, 127.032477);

        // 지도 중심
        CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(latlng1);
        naverMap.moveCamera(cameraUpdate1);

        // 지도 크기
        CameraUpdate cameraUpdate2 = CameraUpdate.zoomTo(15);
        naverMap.moveCamera(cameraUpdate2);

        // 매장1
        Marker marker1 = new Marker();
        marker1.setPosition(latlng1);
        marker1.setMap(naverMap);
        marker1.setSubCaptionText("이디야 YMCA점");
        marker1.setSubCaptionColor(Color.RED);
        // marker1.setSubCaptionHaloColor(Color.rgb(200, 255, 200));
        marker1.setSubCaptionHaloColor(Color.YELLOW);
        marker1.setSubCaptionTextSize(10);

        InfoWindow infoWindow1 = new InfoWindow();
        infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "아메리카노 10% 할인";
            }
        });
        infoWindow1.open(marker1);

        // 매장2
        Marker marker2 = new Marker();
        marker2.setPosition(latlng2);
        marker2.setMap(naverMap);

        marker2.setSubCaptionText("이디야 커피 랩");
        marker2.setSubCaptionColor(Color.RED);
        marker2.setSubCaptionHaloColor(Color.YELLOW);
        marker2.setSubCaptionTextSize(10);

        InfoWindow infoWindow2 = new InfoWindow();
        infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "대학생 20% 할인";
            }
        });
        infoWindow2.open(marker2);
    }
}
