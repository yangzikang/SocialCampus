package com.example.dell.socialcampus.childrenActivity.index.model;

import android.widget.ListView;

import com.example.dell.socialcampus.R;

import java.util.Date;

/**
 * Created by yangzikang on 2017/1/31.
 */

public class SCNewsModel {
    private int    headPicture;
    private int    articlePicture;
    private String userName;
    private String title;
    private String date;

    public int  getHeadPicture() {
        return headPicture;
    }
    public void setHeadPicture(int headPicture) {
        this.headPicture = headPicture;
    }

    public int  getArticlePicture() {
        return articlePicture;
    }
    public void setArticlePicture(int articlePicture) {
        this.articlePicture = articlePicture;
    }

    public String getUserName() {
        return userName;
    }
    public void   setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }
    public void   setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return new Date().toString();
    }
}
