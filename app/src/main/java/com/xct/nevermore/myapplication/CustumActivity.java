package com.xct.nevermore.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustumActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_01)
    TextView tv01;
    @Bind(R.id.tv_02)
    TextView tv02;
    @Bind(R.id.btn_show)
    Button btnShow;
    @Bind(R.id.btn_gone)
    Button btnGone;
    @Bind(R.id.activity_custum)
    LinearLayout activityCustum;
    private String str1;
    private String str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custum);
        ButterKnife.bind(this);
        tvTitle.setText("自定义动画");
        str1 = tv01.getText().toString();
        str2 = tv02.getText().toString();
    }

    @OnClick({R.id.iv_back, R.id.tv_title, R.id.btn_show, R.id.btn_gone})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                tv01.setVisibility(View.VISIBLE);
                tv02.setText("");

                break;
            case R.id.btn_show:
                show();

                break;
            case R.id.btn_gone:
                gone();

                break;
        }
    }

    private void gone() {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv01, "ScaleY", 1, 0);
        scaleY.setDuration(500).setInterpolator(new AccelerateInterpolator());
        scaleY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                tv01.setVisibility(View.GONE);
            }
        });
        scaleY.start();


    }

    private void show() {

        tv02.setText(str2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(400);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        tv02.startAnimation(alphaAnimation);

    }
}
