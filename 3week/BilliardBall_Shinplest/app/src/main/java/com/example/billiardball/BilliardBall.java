package com.example.billiardball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;




//단순히 공을 (0,0) 위치에 100 * 100크기로 그려주는 부분
/*
// step 1
public class BilliardBall extends View {
    private ShapeDrawable mDrawable;

    public BilliardBall(Context context) {
        super(context);

        int x = 0;
        int y = 0;
        int width = 100;
        int height = 100;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.RED);
        mDrawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        mDrawable.draw(canvas);
    }
}
*/


//공이 움직이도록 하는 코드

// step 2
public class BilliardBall extends View {
    private ShapeDrawable mDrawable;

    //당구공의 시작 좌표
    int x = 0;
    int y = 0;
    int width = 100;
    int height = 100;

    int cx, cy;

    int dir_x = 1;
    int dir_y = 1;

    int dx = 30;
    int dy = 40;

    int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;

    public BilliardBall(Context context) {
        super(context);

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.RED);

        // mDrawableRect = new ShapeDrawable(new RectShape());
    }

    //계속 호출되면서 당구공을 움직인다.
    protected void onDraw(Canvas canvas) {
        //당구공의 중심
        cx = x + width / 2;
        cy = y + height / 2;

        //가로방향
        //맨 왼쪽에 있으면 오른쪽으로 이동시키고
        if (cx <= width / 2)
            dir_x = 1;
        //맨 오른쪽에 있으면 왼쪽으로 이동시킨다.
        else if (cx >= screen_width - (width / 2))
            dir_x = -1;

        //세로방향
        //맨위에 있으면 아래로 움직이고
        if (cy <= height / 2)
            dir_y = 1;
        //맨아래에 있으면 위로 움직인다
        else if (cy >= screen_height - (height / 2))
            dir_y = -1;

        //방향과 속도를 곱해서 이동시킨다
        x += dir_x * dx;
        y += dir_y * dy;

        //배경의 색
        canvas.drawColor(Color.BLUE);

        //그래픽 객체의 크기와 위치 지정
        mDrawable.setBounds(x, y, x + width, y + height);
        //캔버스위에 그래픽 객체 출력
        mDrawable.draw(canvas);

        //그래픽 객체를 지우고 계속 다시 그려줌
        invalidate();
    }
}
