package com.example.dell.socialcampus.view.index.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.view.index.adapter.SCNewsAdapter;
import com.example.dell.socialcampus.view.index.model.SCNewsModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangzikang on 2017/1/31.
 */

public class SCNewsFragment extends Fragment {
    private ListView news;
    private List<SCNewsModel> newses  = new LinkedList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        news = (ListView)view.findViewById(R.id.newsList);

        initList();

        SCNewsAdapter newsAdapter = new SCNewsAdapter(newses, getActivity());
        news.setAdapter(newsAdapter);
        return view;
    }

    private void initList(){
        //从数据库中取数据，初始化到list中
        SCNewsModel news = new SCNewsModel();
        news.setHeadPicture(R.drawable.apple);
        news.setUserName("李三");
        news.setArticlePicture(R.drawable.apple);
        news.setTitle("apple");
        newses.add(news);

        SCNewsModel news2 = new SCNewsModel();
        news2.setHeadPicture(R.drawable.hotdog);
        news2.setUserName("李4");
        news2.setArticlePicture(R.drawable.hotdog);
        news2.setTitle("apple");
        newses.add(news2);
    }

}
