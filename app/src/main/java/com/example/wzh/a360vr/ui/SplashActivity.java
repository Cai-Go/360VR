package com.example.wzh.a360vr.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.wzh.a360vr.R;

/**
 * Created by WZH on 2017/9/2.
 */

public class SplashActivity extends AppCompatActivity {

    private TextView mTextView;
    private FrameLayout mFrameLayout;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        setStatusStyle();

        initView();


        setAnnimation();

    }

    private void initView() {
        mTextView = findViewById(R.id.textView);
        mFrameLayout = findViewById(R.id.rootView);
    }

    private void setAnnimation() {


        ObjectAnimator animator = ObjectAnimator.ofFloat(
                mTextView,
                "translationY",
                100
        );

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.setDuration(3000);
        animator.start();

    }

    private void setStatusStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
