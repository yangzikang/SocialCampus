package com.example.dell.socialcampus.manager.messageDistribute;

import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;

/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息
 */

public class SCSender {

    public void sendMessage(SCMessage.Mothed mothed, SCIResponder executer,
                            SCIResponder responder, SCLinkedMap parameters) {
        SCMessage message = createMessage(mothed,executer,responder,parameters);
        SCCommad commad = SCCommad.getInstance();
        commad.addMessage(message);
    }

    synchronized private SCMessage createMessage(SCMessage.Mothed mothed, SCIResponder executer,
                                                 SCIResponder responder, SCLinkedMap parameters){
        SCMessage message = SCMessageFactory.createMessage(mothed,executer,responder,parameters);
        return message;
    }
}

