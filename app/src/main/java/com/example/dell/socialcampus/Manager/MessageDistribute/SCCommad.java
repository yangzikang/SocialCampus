package com.example.dell.socialcampus.Manager.MessageDistribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atong on 2016/12/15.
 */

public class SCCommad {
    private final int FIRST_MESSAGE = 0;
    private static SCCommad commad = new SCCommad();
    private static List<SCMessage> messageQueue = new ArrayList();//manager


    private SCCommad(){}

    public static SCCommad getInstance(){
        return commad;
    }

    public void addMessage(SCMessage message){
        messageQueue.add(message);
        distribute(message);
    }
    public void removeMessage(){
        if(messageQueue != null){
            messageQueue.remove(messageQueue.remove(FIRST_MESSAGE));
        }
    }
    private void distribute(SCMessage message){
        message.setState(SCMessage.State.MESSAGE_STATE_SENDING);
        SCIWorker worker = message.getResponder();
        worker.reciveMessage(message);
    }
}
