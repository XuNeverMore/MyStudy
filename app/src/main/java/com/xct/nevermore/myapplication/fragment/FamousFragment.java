package com.xct.nevermore.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xct.nevermore.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamousFragment extends Fragment {


    public FamousFragment() {
        // Required empty public constructor
    }

    public static FamousFragment newInstance(String str){
        Bundle bundle = new Bundle();
        bundle.putString("name",str);
        FamousFragment famousFragment = new FamousFragment();
        famousFragment.setArguments(bundle);
        return famousFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_famous, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        TextView tv = (TextView) view.findViewById(R.id.tv_name);
        tv.setText(name);
    }
}
