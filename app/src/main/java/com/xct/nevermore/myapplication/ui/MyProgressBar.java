package com.xct.nevermore.myapplication.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.xct.nevermore.myapplication.R;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MyProgressBar extends Dialog {

    private TextView tvMsg;

    public MyProgressBar(Context context) {
        super(context, R.style.MyProgressPar);
        initView();
    }

    private void initView() {
        this.setContentView(R.layout.my_progress);
        tvMsg = (TextView) findViewById(R.id.tv_pb);
    }

    public MyProgressBar setMsg(String msg){
        tvMsg.setText(msg);
        return this;
    }
}
