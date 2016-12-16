package com.example.dell.socialcampus.Manager.ThreadManager;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by atong on 2016/11/25.
 */

public class SCFixedThreadManager{
    private static final int THREAD_COUNT = 5;
    public static ExecutorService returnExecutorService(){
        return Executors.newFixedThreadPool(THREAD_COUNT);
    }

}
