package com.xct.nevermore.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jaeger.library.StatusBarUtil;
import com.xct.nevermore.myapplication.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.btn_calendar)
    Button btnCalendar;
    @Bind(R.id.btn_location)
    Button btnLocation;
    @Bind(R.id.btn_pager)
    Button btnPager;
    @Bind(R.id.btn_lv)
    Button btnLv;
    @Bind(R.id.btn_progress_bar)
    Button btnProgressBar;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(this);
    }

    @OnClick({R.id.btn_key,R.id.btn_swipe_list_view1,R.id.btn_swipe_list_view,R.id.btn_scroll_back,R.id.btn_custom,R.id.btn_statu_bar,R.id.btn_flow,R.id.btn_progress_bar,R.id.btn_location, R.id.btn_lv, R.id.btn_calendar, R.id.btn_pager, R.id.activity_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calendar:
                SianCalendar calendar = new SianCalendar(this);
                calendar.show(activityMain);
                break;
            case R.id.activity_main:
                break;
            case R.id.btn_pager:
                gotoActivity(PagerSlideActivity.class);
                break;
            case R.id.btn_lv:
                gotoActivity(ListViewHeaderActivity.class);
                break;
            case R.id.btn_location:
                gotoActivity(LocationActivity.class);
                break;
            case R.id.btn_progress_bar:
                gotoActivity(ProgressActivity.class);
                break;
            case R.id.btn_flow:
                gotoActivity(FlowActivity.class);
                break;
            case R.id.btn_statu_bar:
                gotoActivity(StatuBarActivity.class);
                break;
            case R.id.btn_custom:
                gotoActivity(CustumActivity.class);
                break;
            case R.id.btn_scroll_back:
                gotoActivity(ScrollActivity.class);
                break;
            case R.id.btn_swipe_list_view:
                gotoActivity(SwipListViewActivity.class);
                break;
            case R.id.btn_swipe_list_view1:
                gotoActivity(SLActivity.class);
                break;
            case R.id.btn_key:
                gotoActivity(KeyActivity.class);
                break;
        }
    }
}
