package com.xct.nevermore.myapplication.data;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/12/28.
 */

public class Data {
    public static ArrayList<String> array = new ArrayList<>();
    public static Random rd = new Random();
    public static String [] data = new String[]{"苹果","香蕉","梨子","橘子"};
    static {
        for (int i = 0; i < 38; i++) {
            array.add(i,i+data[rd.nextInt(data.length)]);
        }
    }

    public static String getText(){
        int i = rd.nextInt(45) + 35;
        StringBuffer sb = new StringBuffer();
        String text = data[rd.nextInt(data.length)];
        for (int j = 0; j < i; j++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
