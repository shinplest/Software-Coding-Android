package com.shinplest.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

/*
리사이클러 뷰 만들기
1. 리사이클러 뷰 그래들에서 가져오기
2. 리사이클러뷰 원하는 화면에 추가
3. 아이템의 뷰를 레이아웃 짜기
4. 아이템과 리사이클러뷰를 연결해주는 어댑터를 구현하기
5. 메인액티비티에서 리사이클러뷰를 불러오고 어댑터를 등록하기!
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            list.add(String.format("TEXT %d", i)) ;
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.rv_main) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        MyAdapter adapter = new MyAdapter(list) ;
        recyclerView.setAdapter(adapter) ;
    }
}
