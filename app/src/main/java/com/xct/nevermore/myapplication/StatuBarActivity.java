package com.xct.nevermore.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StatuBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statu_bar);
        View decorView = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=21){
            int opton = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(opton);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


    }
}
