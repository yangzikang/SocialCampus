package com.example.dell.socialcampus.Manager.MessageDistribute;

/**
 * Created by atong on 2016/12/14.
 */

public interface SCISender {
    public void sendMessage(SCMessage.Mothed mothed, SCIWorker executer,
                            SCIWorker responder, SCLinkedMap parameters);
}
