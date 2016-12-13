package com.example.dell.socialcampus.Manager.ThreadManager;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by atong on 2016/11/25.
 */

public class SCThreadManager{
    private static final int THREAD_COUNT = 5;
    private static SCThreadManager instance = new SCThreadManager();
    private ExecutorService mExecutorService;

    private SCThreadManager(){
        mExecutorService = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public ExecutorService returnExecutorService(){
        return mExecutorService;
    }
    public static SCThreadManager getInstance(){
        return instance;
    }

}
