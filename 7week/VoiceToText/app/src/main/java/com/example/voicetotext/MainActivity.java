package com.example.voicetotext;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    Button   button;
    TextView textView;
    Intent intent;
    SpeechRecognizer mRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.tv);

        // 앱 처음 실행 시, 음성인식 허용 여부 확인 요청
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        }

        // 음성인식을 위한 인텐트 생성
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        ///// 호출하는 현재 패키지명 지정
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        /////  음성인식 언어 설정
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

        // 음성인식 객체 생성과 리스너 설정
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(recognitionListener);
    }

    // 버튼 클릭 시 실행되는 콜백 함수
    public void recognizeVoice(View view) {
        ///// 버튼 문자 설정
        button.setText("말하는 중.....");
        ///// 음성인식 리스너 시작
        mRecognizer.startListening(intent);
    }

    // 음성인식 리스너 객체 생성
    private RecognitionListener recognitionListener = new RecognitionListener() {
        // 사용자가 말할 때까지 대기하는 상태
        @Override
        public void onReadyForSpeech(Bundle bundle) {
            button.setText("음성인식 대기 중...");
            textView.setText("");
        }

        // 사용자가 말하기 시작할 때
        @Override
        public void onBeginningOfSpeech() {
        }

        // 음성의 사운드 수준이 변할 때
        @Override
        public void onRmsChanged(float v) {
        }

        // 여러 소리가 들려질 때
        @Override
        public void onBufferReceived(byte[] bytes) {
        }

        // 사용자가 말을 마칠 때
        @Override
        public void onEndOfSpeech() {
            button.setText("버튼을 누르고 말하세요!");
        }

        // 네트워크 또는 음성인식 에러
        @Override
        public void onError(int i) {
            textView.setText("말이 없네요...");
        }

        // 음성인식 결과
        @Override
        public void onResults(Bundle bundle) {
            ///// 음성인식 결과를 문자형(String) 속성을 갖는 ArrayList에 할당
            ArrayList<String> mResult = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            /////  ArrayList 크기만큼 문자 배열 할당
            String[] rs = new String[mResult.size()];
            ///// 음성인식 결과를 문자열로 변환
            mResult.toArray(rs);

            ///// 음성인식된 문자 출력
            textView.setText(rs[0]);
        }

        // 음성인식이 부분적으로 된 경우
        @Override
        public void onPartialResults(Bundle bundle) {
        }

        // 방생 에정 이벤트 설정
        @Override
        public void onEvent(int i, Bundle bundle) {
        }
    };
}
