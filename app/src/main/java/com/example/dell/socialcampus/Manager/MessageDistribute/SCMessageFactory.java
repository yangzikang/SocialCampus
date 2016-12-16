package com.example.dell.socialcampus.Manager.MessageDistribute;

import com.example.dell.socialcampus.Manager.MessageDistribute.SCLinkedMap;
import com.example.dell.socialcampus.Manager.MessageDistribute.SCMessage;

/**
 * Created by atong on 2016/12/13.
 */

public class SCMessageFactory {
    /**
     *
     * @param mothed        消息的类型
     * @param executer      消息的执行者
     * @param responder     消息的响应者
     * @param parameters    消息所携带的参数
     * @return              消息本身对象
     *
     * createMessage方法内可以放一些逻辑判断，判断生产什么样的消息，然后可以调用消息的set方法做一些初始化
     */
    public static SCMessage createMessage(SCMessage.Mothed mothed, SCIWorker executer,
                                          SCIWorker responder, SCLinkedMap parameters){
        return new SCMessage(mothed,executer,responder,parameters);
    }
}
