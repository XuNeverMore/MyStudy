package com.xct.nevermore.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.xct.nevermore.myapplication.data.Data;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SLActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.list_view)
    ListView listView;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.activity_sl)
    LinearLayout activitySl;
    private ArrayList<String> array;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sl);
        ButterKnife.bind(this);
        initView();


    }

    private void initView() {
        tvTitle.setText("侧滑删除2");
        array = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            array.add(Data.getText());
        }


        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvTitle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                        array.add(0, "吃了");
                    }
                }, 2000);
            }
        });

        myAdapter = new MyAdapter(array, this);

        listView.setAdapter(myAdapter);

    }

    @OnClick({R.id.iv_back, R.id.tv_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                initView();
                break;
        }
    }

    class MyAdapter extends BaseXAdapter<String> {


        public MyAdapter(List<String> mList, Context context) {
            super(mList, context);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.swip_item, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvContent.setText(mList.get(position));
            int i = Data.rd.nextInt(2);
            if (i == 0) {
                holder.ivIcon.setImageResource(R.mipmap.wd_boy_nol);
            } else {
                holder.ivIcon.setImageResource(R.mipmap.wd_girl_nol);
            }

            holder.tvDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mList.remove(position);
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }

    }

    static class ViewHolder {
        @Bind(R.id.tv_del)
        TextView tvDel;
        @Bind(R.id.iv_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_content)
        TextView tvContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
