package com.example.dell.socialcampus.Manager.MessageDistribute;

import android.app.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息
 */

public class SCSender implements SCISender {

    @Override
    public void sendMessage(SCMessage.Mothed mothed, SCIWorker executer,
                            SCIWorker responder, SCLinkedMap parameters) {
        SCMessage message = createMessage(mothed,executer,responder,parameters);
        SCCommad commad = SCCommad.getInstance();
        commad.addMessage(message);
    }

    synchronized private SCMessage createMessage(SCMessage.Mothed mothed, SCIWorker executer,
                                 SCIWorker responder, SCLinkedMap parameters){
         SCMessage message = SCMessageFactory.createMessage(mothed,executer,responder,parameters);
        return message;
    }
}

