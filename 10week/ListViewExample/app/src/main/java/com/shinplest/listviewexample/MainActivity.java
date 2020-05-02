package com.shinplest.listviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//리스트 뷰 만들기 예제
/*
1. 레이아웃에 리스트뷰를 추가한다.
2. 리스트의 레이아웃을 만든다.
3. 데이터를 담을 클래스를 정의한다.
4. 데이터와 레이아웃을 연결시켜줄 어댑터를 만든다.
5. 어댑터와 리스트뷰를 연결한다.

 */

public class MainActivity extends AppCompatActivity {

    ArrayList<SampleData> movieDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeMovieData();

        ListView listView = (ListView) findViewById(R.id.lv_main);
        final MyAdapter myAdapter = new MyAdapter(this, movieDataList);


        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getMovieName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializeMovieData() {
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData(R.drawable.movieposter1, "백두산", "15세 이상관람가"));
        movieDataList.add(new SampleData(R.drawable.movieposter2, "기생충", "19세 이상관람가"));
        movieDataList.add(new SampleData(R.drawable.movieposter3, "마녀", "12세 이상관람가"));
    }
}

