package com.example.dell.socialcampus.childrenActivity.index.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.childrenActivity.index.adapter.SCNewsAdapter;

/**
 * Created by yangzikang on 2017/2/9.
 */

public class SCMineFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }
}
