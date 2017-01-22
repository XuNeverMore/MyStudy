package com.xct.nevermore.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xct.nevermore.myapplication.ui.MyProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.activity_progress)
    LinearLayout activityProgress;
    @Bind(R.id.btn_progress_bar)
    Button btnProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("各种进度条");
    }

    @OnClick({R.id.btn_progress_bar,R.id.iv_back, R.id.activity_progress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.activity_progress:
                break;
            case R.id.btn_progress_bar:
                new MyProgressBar(this).setMsg("哈哈哈...").show();
                break;
        }
    }
}
