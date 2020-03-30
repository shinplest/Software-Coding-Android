package com.example.clayshootinggame;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// step 1
/*
public class MainActivity extends AppCompatActivity {
    ImageView iv_gun;
    ImageView iv_bullet;
    ImageView iv_clay;

    double screen_width, screen_height;
    float bullet_height, bullet_width;
    float gun_height, gun_width;
    float clay_height, clay_width;
    float bullet_center_x, bullet_center_y;
    float clay_center_x, clay_center_y;
    double gun_x, gun_y;
    double gun_center_x;

    final int NO_OF_CLAYS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.layout);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screen_width = size.x;
        screen_height = size.y;

        iv_bullet = new ImageView(this);
        iv_gun    = new ImageView(this);
        iv_clay   = new ImageView(this);

        iv_gun.setImageResource(R.drawable.gun);
        iv_gun.measure(iv_gun.getMeasuredWidth(), iv_gun.getMeasuredHeight());
        gun_height = iv_gun.getMeasuredHeight();
        gun_width = iv_gun.getMeasuredWidth();
        layout.addView(iv_gun);

        iv_bullet.setImageResource(R.drawable.bullet);
        iv_bullet.measure(iv_bullet.getMeasuredWidth(), iv_bullet.getMeasuredHeight());
        bullet_height = iv_bullet.getMeasuredHeight();
        bullet_width  = iv_bullet.getMeasuredWidth();
        iv_bullet.setVisibility(View.INVISIBLE);
        layout.addView(iv_bullet);

        iv_clay.setImageResource(R.drawable.clay);
        iv_clay.setScaleX(0.8f);
        iv_clay.setScaleY(0.8f);
        iv_clay.measure(iv_bullet.getMeasuredWidth(), iv_bullet.getMeasuredHeight());
        clay_height = iv_clay.getMeasuredHeight();
        clay_width  = iv_clay.getMeasuredWidth();
        // iv_clay.setVisibility(View.INVISIBLE);  // step 2
        layout.addView(iv_clay);

        gun_center_x = screen_width * 0.7;
        gun_x = gun_center_x - gun_width * 0.5;
        gun_y = screen_height - gun_height;
        iv_gun.setX((float)gun_x);
        iv_gun.setY((float)gun_y - 100f);

        ObjectAnimator clay_translateX = ObjectAnimator.ofFloat(iv_clay, "translationX", -200f, (float)screen_width + 100f);
        ObjectAnimator clay_translateY = ObjectAnimator.ofFloat(iv_clay, "translationY", 50f, 50f);
        ObjectAnimator clay_rotation   = ObjectAnimator.ofFloat(iv_clay, "rotation", 0f, 1080f);
        clay_translateX.setRepeatCount(NO_OF_CLAYS-1);
        clay_translateY.setRepeatCount(NO_OF_CLAYS-1);
        clay_rotation.setRepeatCount(NO_OF_CLAYS-1);
        clay_translateX.setDuration(3000);
        clay_translateY.setDuration(3000);
        clay_rotation.setDuration(3000);

        clay_translateX.start();
        clay_translateY.start();
        clay_rotation.start();
    }
}
*/

// step 2
public class MainActivity extends AppCompatActivity {
    ImageView iv_gun;
    ImageView iv_bullet;
    ImageView iv_clay;
    TextView tv_score;

    double screen_width, screen_height;
    float bullet_height, bullet_width;
    float gun_height, gun_width;
    float clay_height, clay_width;
    float bullet_center_x, bullet_center_y;
    float clay_center_x, clay_center_y;
    double gun_x, gun_y;
    double gun_center_x;
    int score;

    //총알이 날아올 횟수를 지정한다
    final int NO_OF_CLAYS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃을 가져온다
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        //화면을 가져온다.
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        //화면의 가로크기와 세로크기를 가져온다.
        screen_width = size.x;
        screen_height = size.y;

        //총알과 총, 날아오는 공 이미지를 담을 이미지뷰를 생성한다.
        iv_bullet = new ImageView(this);
        iv_gun = new ImageView(this);
        iv_clay = new ImageView(this);
        tv_score = findViewById(R.id.tv_score);


        //이미지뷰에 총을 추가한다.
        iv_gun.setImageResource(R.drawable.gun);
        //이미지의 폭과 너비를 측정한다.
        iv_gun.measure(iv_gun.getMeasuredWidth(), iv_gun.getMeasuredHeight());
        //이미지의 폭과 너비를 저장한다.
        gun_height = iv_gun.getMeasuredHeight();
        gun_width = iv_gun.getMeasuredWidth();
        //레이아웃에 총을 추가한다.
        layout.addView(iv_gun);

        //이미지 뷰에 총알을 추가한다. (나머지는 위와 같음)
        iv_bullet.setImageResource(R.drawable.bullet);
        iv_bullet.measure(iv_bullet.getMeasuredWidth(), iv_bullet.getMeasuredHeight());
        bullet_height = iv_bullet.getMeasuredHeight();
        bullet_width = iv_bullet.getMeasuredWidth();
        iv_bullet.setVisibility(View.INVISIBLE);
        layout.addView(iv_bullet);

        //이미지뷰에 날아오는 공을 추가한다.
        iv_clay.setImageResource(R.drawable.clay);
        //이미지의 크기를 0.5배로 한다.
        iv_clay.setScaleX(0.5f);
        iv_clay.setScaleY(0.5f);
        //측정하고 저장한다.
        iv_clay.measure(iv_bullet.getMeasuredWidth(), iv_bullet.getMeasuredHeight());
        clay_height = iv_clay.getMeasuredHeight();
        clay_width = iv_clay.getMeasuredWidth();
        iv_clay.setVisibility(View.INVISIBLE);   // step 2
        layout.addView(iv_clay);

        //총의 위치를 지정한다.
        gun_center_x = screen_width * 0.7;
        gun_x = gun_center_x - gun_width * 0.5;
        gun_y = screen_height - gun_height;
        iv_gun.setX((float) gun_x);
        iv_gun.setY((float) gun_y - 100f);

        //x축 변화
        ObjectAnimator clay_translateX = ObjectAnimator.ofFloat(iv_clay, "translationX", -200f, (float) screen_width + 100f);
        //y축 변화
        ObjectAnimator clay_translateY = ObjectAnimator.ofFloat(iv_clay, "translationY", 50f, 50f);
        //회전 변화
        ObjectAnimator clay_rotation = ObjectAnimator.ofFloat(iv_clay, "rotation", 0f, 1080f);
        clay_translateX.setRepeatCount(NO_OF_CLAYS - 1);
        clay_translateY.setRepeatCount(NO_OF_CLAYS - 1);
        clay_rotation.setRepeatCount(NO_OF_CLAYS - 1);
        //각각의 애니메이션에 길이설정
        clay_translateX.setDuration(2000);
        clay_translateY.setDuration(2000);
        clay_rotation.setDuration(2000);

        //애니메이션에 귀를 달아준다! -> 버튼 클릭리스너와 같은 개념이다.
        clay_translateX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                ///애니메이션이 시작하면 클레이를 보이게 해주고 점수를 초기화 해준다.
                iv_clay.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(getApplicationContext(), "게임 종료!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                iv_clay.setVisibility(View.VISIBLE);
            }
        });

        clay_translateX.start();
        clay_translateY.start();
        clay_rotation.start();

        //총을 클릭했을때, -> 총에 귀를 달아줌
        iv_gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //총알을 보이게 해준다.
                iv_bullet.setVisibility(View.VISIBLE);

                //멀어지면 총알을 작게만들어주는 부분
                ObjectAnimator bullet_scaleDownX = ObjectAnimator.ofFloat(iv_bullet, "scaleX", 1.0f, 0.0f);
                ObjectAnimator bullet_scaleDownY = ObjectAnimator.ofFloat(iv_bullet, "scaleY", 1.0f, 0.0f);

                double bullet_x = gun_center_x - bullet_width / 2;
                ObjectAnimator bullet_translateX = ObjectAnimator.ofFloat(iv_bullet, "translationX", (float) bullet_x, (float) bullet_x);
                ObjectAnimator bullet_translateY = ObjectAnimator.ofFloat(iv_bullet, "translationY", (float) gun_y, 30);

                bullet_translateY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        bullet_center_x = iv_bullet.getX() + bullet_width * 0.5f;
                        bullet_center_y = iv_bullet.getY() + bullet_height * 0.5f;

                        clay_center_x = iv_clay.getX() + clay_width * 0.5f;
                        clay_center_y = iv_clay.getY() + clay_height * 0.5f;

                        //두 점 사이의 거리 공식
                        double dist = Math.sqrt(Math.pow(bullet_center_x - clay_center_x, 2) + Math.pow(bullet_center_y - clay_center_y, 2));
                        //총알과 공의 거리가 50이하이면
                        if (dist <= 50) {
                            score++;
                            tv_score.setText("Score : " + score);
                            iv_clay.setVisibility(View.INVISIBLE);
                        }
                    }
                });

                AnimatorSet bullet = new AnimatorSet();
                bullet.playTogether(bullet_translateX, bullet_translateY, bullet_scaleDownX, bullet_scaleDownY);
                bullet.setDuration(500);
                bullet.start();
            }
        });
    }

}
