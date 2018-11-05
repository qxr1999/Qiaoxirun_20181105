package com.revicden.qiaoxirun_20181105;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.BoringLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * 作者: Created by Revicden
 * 时间: On 2018/11/5  08:51
 * 邮箱: 18235420811@163.com
 */
public class CustomerView extends View {

    private RectF rectF;
    private Paint mPaint;
    private boolean isStart = false;
    private Paint mPaint1;
    private String[] contents = new String[]{
            "一 等 奖","二 等 奖","三 等 奖","四 等 奖","五 等 奖","六 等 奖",
    };
    private RotateAnimation rotateAnimation;

    public CustomerView(Context context) {
        this(context,null);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        //initAnim();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getclick != null) {
                    getclick.clickView(v);
                }
            }
        });

    }




    private void initPaint() {
        rectF = new RectF(200, 200, 600, 600);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);

        mPaint1 = new Paint();
        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(3);
        mPaint1.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(800,800);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[] colors = new int[]{
          Color.GRAY,Color.GREEN,Color.BLUE,Color.YELLOW,Color.BLACK,Color.RED,
        };
        canvas.drawCircle(400,400,200,mPaint);
        float start = 60;
        for (int i = 0; i <6 ; i++) {
            mPaint.setColor(colors[i]);
            canvas.drawArc(rectF,start*i,60,true,mPaint);
        }
        for (int i = 0; i <6 ; i++) {
            mPaint.setColor(Color.BLACK);
            mPaint1.setTextSize(35);
            Path path = new Path();
            path.addArc(rectF,start*i,60);
            canvas.drawTextOnPath(contents[i],path,60,60,mPaint);
        }

        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.FILL);
        canvas.drawCircle(400,400,50,mPaint1);


        mPaint1.setColor(Color.WHITE);
        mPaint1.setTextSize(25);
        Rect rect = new Rect();
        mPaint1.getTextBounds("start",0,5,rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText("start",400-width/2,400+height/2,mPaint1);
    }

    public getClick getclick;


            public void onClick(View v) {

            }


    public void setGetclick(getClick getclick) {
        this.getclick = getclick;
    }

    interface getClick{
        void clickView(View v);
    }

}
