package com.example.dell.socialcampus.manager.messageDistribute;
import com.example.dell.socialcampus.utill.networkRequest.DoGET;

/**
 * Created by yangzikang on 2017/1/23.
 * 做映射从
 */

public enum SCMothed {
    LOGIN,UPDATE;

    public static SCIResponder returnResponder(SCMothed mothed){
        switch (mothed) {
            case LOGIN:
                return new DoGET();
            case UPDATE:
                System.out.println("还未实现");
                break;
            default:
                return null;
        }
        return null;
    }

}
