package com.example.dell.socialcampus.Manager.MessageDistribute;

import android.util.Log;

/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage {
    //枚举变量容易造成内存泄漏
    public enum Mothed{
        QUERY,UPDATE
    }
    public enum State{
        MESSAGE_STATE_CREATE, MESSAGE_STATE_SENDING,MESSAGE_STATE_SUCCEED,
        MESSAGE_STATE_FAILED,MESSAGE_STATE_DISTROY
    }
    public enum Error{
        MESSAGE_ERROR_OVERTIME,MESSAGE_ERROR_NORESPONDER,MESSAGE_ERROR_NOUSE
    }
    private static int numberForId   = 0;       //消息的
    private final  int MAXTIME       = 10000;   //最大等待时间
    private final  int MAXRESENDTIME = 5;       //最大重传数

    private int         messageId;           //消息ID
    private int         resendTime;          //重传次数
    private boolean     isOverTime;          //是否超时
    private Mothed      mothed;              //消息类型
    private SCLinkedMap parameters;          //携带的数据
    private SCIWorker   responder;           //响应者(接受者，消息的消费)
    private SCIWorker   executer;            //执行者(调用者，消息的产生)
    private State       state;               //状态码
    private Error       error;               //错误域

    /**
     * 类似JavaBean
     */
    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }
    public void setError(Error error) {
        this.error = error;
    }
    public Error getError(){
        return error;
    }
    public void setParameters(SCLinkedMap parameters){
        this.parameters = parameters;
    }
    public SCLinkedMap getParameters(){
        return parameters;
    }
    public void setResponder(SCIWorker responder){
        this.responder = responder;
    }
    public SCIWorker getResponder() {
        return responder;
    }
    public void setMothed(Mothed mothed){this.mothed = mothed;}
    public Mothed getMothed(){return mothed;}
    public void setIsOverTime(boolean isOverTime){
        this.isOverTime = isOverTime;
    }
    public boolean getIsOverTime(){
        return isOverTime;
    }

    /**
     * 构造函数
     */
    public SCMessage(Mothed mothed,SCIWorker executer,SCIWorker responder,SCLinkedMap parameters){
        init(mothed, executer, responder, parameters);
    }
    /**
     * 初始化函数
     */
     public void init(Mothed mothed,SCIWorker executer,SCIWorker responder,SCLinkedMap parameters){
         messageId = numberForId;
         numberForId++;
         state = State.MESSAGE_STATE_CREATE;
         this.mothed = mothed;
         this.executer = executer;
         this.responder = responder;
         this.resendTime = 0;
         this.isOverTime = false;
         this.parameters = parameters;
     }

}
