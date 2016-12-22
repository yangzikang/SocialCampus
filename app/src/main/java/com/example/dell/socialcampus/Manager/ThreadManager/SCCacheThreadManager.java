package com.example.dell.socialcampus.manager.threadManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by atong on 2016/12/16.
 */

public class SCCacheThreadManager{
    public static ExecutorService returnExecutorService(){
        return Executors.newCachedThreadPool();
    }
}
