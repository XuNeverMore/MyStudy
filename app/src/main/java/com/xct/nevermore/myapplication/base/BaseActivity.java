package com.xct.nevermore.myapplication.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xct.nevermore.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    abstract public int getRootViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootViewId());
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void gotoActivity(Class clazz){
        startActivity(new Intent(this,clazz));
    }
}
