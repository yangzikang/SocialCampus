package com.example.dell.socialcampus.manager.threadManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by atong on 2016/11/25.
 */

public class SCFixedThreadManager{
    private static final int THREAD_COUNT = 5;
    public static ExecutorService returnExecutorService(){
        return Executors.newFixedThreadPool(THREAD_COUNT);
    }

}
