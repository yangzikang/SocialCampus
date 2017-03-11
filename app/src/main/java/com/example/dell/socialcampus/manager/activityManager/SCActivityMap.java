package com.example.dell.socialcampus.manager.activityManager;

import android.app.Activity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by dell on 2016/10/21.
 */

public class SCActivityMap {

    private Map<String,Activity> activities = new HashMap<>();
    private static SCActivityMap activityMap = new SCActivityMap();

    public static SCActivityMap getInstance(){
        return activityMap;
    }

    public void addActivity(String activityKey,Activity activity){
        activities.put(activityKey,activity);
    }

    public void removeActivity(String activityKey){
        activities.remove(activityKey);
    }

    public Activity getActivityByName(String activityKey){
        Activity activity = activities.get(activityKey);
        return activity;
    }

    public int returnActivityCount(){
        return activities.size();
    }

    public void finishAllActivity(){
        //利用迭代器，获取遍历容器
        Iterator iterator = activities.keySet().iterator();
        while (iterator.hasNext()) {
            String activitykey = (String)iterator.next();
            Activity activity = getActivityByName(activitykey);

            activity.finish();
        }

    }

}
