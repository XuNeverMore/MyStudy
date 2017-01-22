package com.xct.nevermore.myapplication;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */

public class SianCalendar {
    public static String TAG = "SianCalendar";
    private PopupWindow popupWindow;
    private Context context;
    private TextView tvSignMsg;
    private GridView gdCalendar;

    public SianCalendar(Context context) {
        this.context = context;
        initView();
        //展示日历
        setCalendar();
    }

    public void show(View view) {
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 100);
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sign_calendar_layout, null, false);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        tvSignMsg = (TextView) view.findViewById(R.id.tv_sign_msg);
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        gdCalendar = (GridView) view.findViewById(R.id.gd_sign);
    }

    private void setCalendar() {
        String[] weekday = new String[]{"日","一", "二", "三", "四", "五", "六" };
        Date date = new Date();
        Calendar instance = Calendar.getInstance();

        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);

        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < weekday.length; j++) {
            list.add(weekday[j]);
        }

        instance.set(Calendar.DAY_OF_MONTH,1);
        int xingqiji = instance.get(Calendar.DAY_OF_WEEK);
        for (int j = 0; j < xingqiji - 1; j++) {
            list.add("");
        }
        for (int q = 1; q < getDaysOfMonth(year,month) + 1; q++) {
            list.add("" + q);
        }
        gdCalendar.setAdapter(new CalendarAdapter(list, context));

    }

    class CalendarAdapter extends BaseXAdapter<String> {

        public CalendarAdapter(List<String> mList, Context context) {
            super(mList, context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(mList.get(position));

            return convertView;
        }
    }

    public int getDaysOfMonth(int year, int month) {
        int[] monDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (((year) % 4 == 0 && (year) % 100 != 0) || (year) % 400 == 0){
            monDays[1]++;
        }
        return monDays[month];
    }



}
