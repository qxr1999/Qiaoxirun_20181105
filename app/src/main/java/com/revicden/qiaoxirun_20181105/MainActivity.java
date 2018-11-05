package com.revicden.qiaoxirun_20181105;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {
    private boolean isStart = false;
    private CustomerView mCustomerView;
    private RotateAnimation rotateAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       mCustomerView.setGetclick(new CustomerView.getClick() {
           @Override
           public void clickView(View v) {
               if (!isStart){
                   rotateAnimation = new RotateAnimation(0f, 360f,
                           Animation.RELATIVE_TO_SELF, 0.5f,
                           Animation.RELATIVE_TO_SELF, 0.5f);
                   rotateAnimation.setRepeatCount(-1);
                   rotateAnimation.setFillAfter(true);
                   isStart=true;
                   rotateAnimation.setDuration(1000);
                   rotateAnimation.setInterpolator(new LinearInterpolator());
                    v.startAnimation(rotateAnimation);
               }else{
                   isStart=false;
                    v.clearAnimation();
               }
           }
       });
    }

    private void initView() {
        mCustomerView = (CustomerView) findViewById(R.id.customer_view);
    }
}
