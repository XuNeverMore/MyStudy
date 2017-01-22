package com.xct.nevermore.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @ClassName:BaseXAdapter
 * @PackageName:com.shengwugou.adapter
 * @Created by xuchuanting
 * @on 2016/12/19 0019.
 * @Site:http://www.handongkeji.com
 * @Copyrights 2016/12/19 0019 handongkeji All rights reserved.
 */
public class BaseXAdapter<T> extends BaseAdapter {
    public List<T> mList;
    public Context mContext;
    public final LayoutInflater mInflater;

    public BaseXAdapter(List<T> mList, Context context) {
        this.mList = mList;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList==null?null:mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList==null?0:position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return null;
    }




}
