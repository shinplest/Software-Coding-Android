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
        //액티비티와 레이아웃을 연결시켜준다
        setContentView(R.layout.activity_main);
        //비디오뷰를 액티비티로 가져온다
        VideoView videoview = (VideoView) findViewById(R.id.videoview);
        //비디오뷰의 경로를 넣어준다
        videoview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.fountain_night);
        //미디어 컨트롤러를 생성한다. (재생, 정지 보여주는 기능)
        MediaController myController = new MediaController(this);
        //컨트롤러에 비디오뷰를 연결한다
        myController.setAnchorView(videoview);
        //비디오뷰에 컨트롤러를 연결한다.
        videoview.setMediaController(myController);
        //비디오를 시작시킨다.
        videoview.start();
    }
}
