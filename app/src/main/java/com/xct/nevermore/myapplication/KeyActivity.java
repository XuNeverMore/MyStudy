package com.xct.nevermore.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xct.nevermore.myapplication.ui.SlideBackLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeyActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_top_bar)
    RelativeLayout rlTopBar;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.edit)
    EditText edit;
    @Bind(R.id.activity_key)
    RelativeLayout activityKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
        SlideBackLayout slideBackLayout = new SlideBackLayout(this);
        slideBackLayout.bind();
        ButterKnife.bind(this);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvContent.setText(edit.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                break;
        }
    }
}
