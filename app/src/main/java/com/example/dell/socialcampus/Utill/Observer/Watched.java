package com.example.dell.socialcampus.Utill.Observer;

import java.util.Objects;

/**
 * Created by dell on 2016/10/20.
 */

public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(Object message);
}
