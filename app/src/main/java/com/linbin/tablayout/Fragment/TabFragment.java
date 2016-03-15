package com.linbin.tablayout.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linbin.tablayout.R;

/**
 * Created by linbin_dian91 on 2016/3/15.
 */
public class TabFragment extends Fragment{

    private  View view;
    private  String content;
    private TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tabfragment,container,false);
        textView = (TextView) view.findViewById(R.id.content);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        content = getArguments().getString("content");
        textView.setText(content);
    }
}
