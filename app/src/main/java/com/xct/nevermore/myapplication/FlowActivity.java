package com.xct.nevermore.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xct.nevermore.myapplication.ui.FlowTagLayout;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlowActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ft1)
    FlowTagLayout ft1;
    @Bind(R.id.ft2)
    FlowTagLayout ft2;
    @Bind(R.id.activity_flow)
    LinearLayout activityFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("FLOWLAYOUT");
        Random random = new Random();
        int count1 = random.nextInt(8)+1;

        int count2 = random.nextInt(9) + 1;


        ArrayList<String> list1 = getListByCount(count1);

        ArrayList<String> list2 = getListByCount(count2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.simple_text1, list1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.simple_text1, list2);

        ft1.setAdapter(adapter1);
        ft2.setAdapter(adapter2);

    }

    private ArrayList<String> getListByCount(int count){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String str = getNumStr(i);
            list.add(str);
        }

        return list;
    }

    private String getNumStr(int count) {
        String str ="";
        String s = String.valueOf(count);
        for (int i = 0; i < new Random().nextInt(10)+count; i++) {
            str+=s;
        }
        return str;
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
