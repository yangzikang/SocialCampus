package com.example.dell.socialcampus.manager.messageDistribute;

import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;
/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息,交由控制台分发
 */

public class SCSender{

    SCMessage message = null;

    public void sendMessage(SCMothed mothed, SCIResponder executer, SCLinkedMap parameters) {
        message = createMessage(mothed,executer,parameters);
        distribute(message);
    }

    synchronized private SCMessage createMessage(SCMothed mothed, SCIResponder executer, SCLinkedMap parameters){
        SCMessage message = SCMessageFactory.createMessage(mothed,executer,parameters);
        return message;
    }

    private void distribute(SCMessage message){
        if(message.getResponder()!=null){  //获取响应者
            SCIResponder worker = message.getResponder();
            worker.reciveMessage(message);
        }
        else{                             //设置无响应者错误错误
            message.setError(SCMessage.Error.MESSAGE_ERROR_NORESPONDER);
        }
    }
}

