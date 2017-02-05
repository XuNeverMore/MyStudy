package com.xct.nevermore.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xct.nevermore.myapplication.baseinterface.OnGetString;
import com.xct.nevermore.myapplication.ui.SlideLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationActivity extends AppCompatActivity {

    @Bind(R.id.btn_get_locaton)
    Button btnGetLocaton;
    @Bind(R.id.tv_location)
    TextView tvLocation;
    @Bind(R.id.activity_location)
    LinearLayout activityLocation;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_more)
    ImageView ivMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);
        new SlideLayout(this).bindActivity(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_get_locaton})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_get_locaton:
                MyApp app = (MyApp) getApplication();
                app.startLocation(new OnGetString() {
                    @Override
                    public void getString(String msg) {
                        tvLocation.setText(msg);
                    }
                });
                break;
        }
    }
}
