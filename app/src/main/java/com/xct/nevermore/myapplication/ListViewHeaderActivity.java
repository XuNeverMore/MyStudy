package com.xct.nevermore.myapplication;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xct.nevermore.myapplication.data.Data;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewHeaderActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.activity_list_view_header)
    LinearLayout activityListViewHeader;
    @Bind(R.id.iv_more)
    ImageView ivMore;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_header);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("在listView上加了头部视图");
        inflater = LayoutInflater.from(this);
        ImageView iv = (ImageView) inflater.inflate(R.layout.img, null, false);
        Glide.with(this).load(R.mipmap.wd_tab_bg).into(iv);
        lv.addHeaderView(iv);
        ArrayList<String> array = Data.array;
//        array = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(adapter);

    }

    @OnClick({R.id.iv_back, R.id.tv_title,R.id.iv_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                break;
            case R.id.iv_more:
                View view1 = inflater.inflate(R.layout.option, null);

                PopupWindow popupWindow = new PopupWindow(view1,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        true);
                popupWindow.setAnimationStyle(R.style.AnimationPop);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAsDropDown(ivMore);

                View ll = view1.findViewById(R.id.ll_change);
                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lv.setAdapter(null);
                    }
                });
                break;
        }
    }
}
