package com.example.dell.socialcampus.utill.observer;




import java.util.ArrayList;

/**
 * Created by yangzikang on 2016/10/19.
 *
 * 通知中心代码，实现方式是同步观察者模式
 * android中广播机制即一个观察者模式。但是广播机制比较重型，而自己做的通知中心就比较轻量级
 */

public class SCNotificationCenter implements SCIWatched {

    private ArrayList<SCIWatcher>   watchers = new ArrayList<>();
    private static  SCNotificationCenter notificationCenter = new SCNotificationCenter();

    private SCNotificationCenter(){
    }

    //getInstance(); 保证唯一通知中心
    public static SCNotificationCenter defaultCenter(){
        if(notificationCenter != null){
            return notificationCenter;
        }
        else{
            notificationCenter = new SCNotificationCenter();
            return notificationCenter;
        }
    }

    @Override
    public void addWatcher(SCIWatcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(SCIWatcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatchers(Object message) {
        for(SCIWatcher watcher: watchers){
            watcher.update(message);
        }
    }
}
