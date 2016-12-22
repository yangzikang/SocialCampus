package com.example.dell.socialcampus.manager.threadManager;

import java.util.concurrent.ExecutorService;

/**
 * Created by atong on 2016/12/16.
 */

public class SCThreadPoolFactory {
    public static final int FIXED = 1;
    public static final int CACHE = 2;

    public static ExecutorService createThreadManager(int type){
        if(type == FIXED){
            ExecutorService executorService = SCFixedThreadManager.returnExecutorService();
            return executorService;
        }
        else if(type == CACHE){
            ExecutorService executorService = SCCacheThreadManager.returnExecutorService();
            return executorService;
        }
        else{
            return null;
        }
    }
}
