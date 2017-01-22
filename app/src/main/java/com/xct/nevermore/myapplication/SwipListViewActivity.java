package com.xct.nevermore.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.swipelayoutexample.SwipeLayout;
import com.xct.nevermore.myapplication.data.Data;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipListViewActivity extends AppCompatActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.list_view)
    ListView listView;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.activity_swip_list_view)
    LinearLayout activitySwipListView;
    private ArrayList<String> array;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swip_list_view);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        array = Data.array;

        myAdapter = new MyAdapter(array, this);
        listView.setAdapter(myAdapter);


    }

    class MyAdapter extends BaseXAdapter<String> {

        public MyAdapter(List<String> mList, Context context) {
            super(mList, context);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.activity_main_01, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvContent.setText(mList.get(position));
            holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"删除"+position,Toast.LENGTH_LONG);
                    mList.remove(position);
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }


    }
    static class ViewHolder {
        @Bind(R.id.swip_layout)
        SwipeLayout swipLayout;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.delete_button)
        RelativeLayout deleteButton;
        @Bind(R.id.view_button)
        RelativeLayout viewButton;
        @Bind(R.id.star_button)
        RelativeLayout starButton;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
