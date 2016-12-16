package com.example.dell.socialcampus.Manager.MessageDistribute;

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.socialcampus.Manager.MessageDistribute.SCMessage.MAXRESENDTIME;

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

    synchronized public void addMessage(SCMessage message){
        messageQueue.add(message);
        message.setState(SCMessage.State.MESSAGE_STATE_SENDING);
        distribute(message);
    }
    public void removeMessage(){
        if(messageQueue != null){
            messageQueue.remove(messageQueue.remove(FIRST_MESSAGE));
            messageQueue.get(FIRST_MESSAGE).setState(SCMessage.State.MESSAGE_STATE_DISTROY);
        }
    }
    private void resendMessage(SCMessage message){
        if(message.getResendTime()<MAXRESENDTIME){
            message.setResendTime((message.getResendTime())+1);
            addMessage(message);
        }
        else{
            message.setError(SCMessage.Error.MESSAGE_ERROR_OVERTIME);
        }
    }
    private void distribute(SCMessage message){
        SCIResponder worker = message.getResponder();
        boolean isSucceed = worker.reciveMessage(message);
        if(isSucceed){
            message.setState(SCMessage.State.MESSAGE_STATE_SUCCEED);
        }
        else{
            message.setState(SCMessage.State.MESSAGE_STATE_FAILED);
            removeMessage();
            resendMessage(message);
        }
        removeMessage();
    }


}
