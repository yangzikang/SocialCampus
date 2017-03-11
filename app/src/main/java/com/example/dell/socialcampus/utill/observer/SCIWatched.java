package com.example.dell.socialcampus.utill.observer;

/**
 * Created by dell on 2016/10/20.
 */

public interface SCIWatched {

    public void addWatcher(SCIWatcher watcher);

    public void removeWatcher(SCIWatcher watcher);

    public void notifyWatchers(Object message);
}
