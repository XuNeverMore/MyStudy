package com.xct.nevermore.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xct.nevermore.myapplication.base.BaseActivity;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_container)
    LinearLayout llContainer;
    @Bind(R.id.scrollView)
    ScrollView scrollView;

    @Override
    public int getRootViewId() {
        return R.layout.activity_scroll;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(256);
            int b = random.nextInt(256);
            int c = random.nextInt(256);
            int argb = Color.argb(random.nextInt(256), a, b, c);
            TextView textView = new TextView(this);
            if(i%2==0){
                textView.setWidth(100);
            }else {
            textView.setWidth(-2);

            }
            textView.setHeight(random.nextInt(200)+300);



            textView.setBackgroundColor(argb);
            textView.setText("第"+i+"块砖");
            textView.setGravity(Gravity.CENTER);

            llContainer.addView(textView);
        }

    }

    @OnClick({R.id.iv_back, R.id.tv_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                gotoActivity(GuideActivity.class);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        scrollView.scrollTo(0,0);
    }
}
