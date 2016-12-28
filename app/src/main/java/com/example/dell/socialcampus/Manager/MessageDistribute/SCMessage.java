package com.example.dell.socialcampus.manager.messageDistribute;

import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;

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
        MESSAGE_ERROR_OVERTIME,MESSAGE_ERROR_NORESPONDER,MESSAGE_ERROR_EEEE
    }
    private static       int numberForId   = 0;       //消息的
    public  static final int MAXRESENDTIME = 5;       //最大重传数

    private int          messageId;           //消息ID
    private int          resendTime;          //重传次数
    private Mothed       mothed;              //消息类型
    private SCLinkedMap parameters;          //携带的数据
    private SCIResponder responder;           //响应者(接受者，消息的消费)
    private SCIResponder executer;            //执行者(调用者，消息的产生)
    private State        state;               //状态码
    private Error        error;               //错误域

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
    public void setResponder(SCIResponder responder){
        this.responder = responder;
    }
    public SCIResponder getResponder() {
        return responder;
    }
    public void setMothed(Mothed mothed){
        this.mothed = mothed;
    }
    public Mothed getMothed(){
        return mothed;
    }
    public void setResendTime(int resendTime){
        this.resendTime = resendTime;
    }
    public int getResendTime(){
        return resendTime;
    }

    /**
     * 构造函数
     */
    public SCMessage(Mothed mothed, SCIResponder executer, SCIResponder responder, SCLinkedMap parameters){
        init(mothed, executer, responder, parameters);
    }
    /**
     * 初始化函数
     */
     public void init(Mothed mothed, SCIResponder executer, SCIResponder responder, SCLinkedMap parameters){
         messageId = numberForId;
         numberForId++;
         state = State.MESSAGE_STATE_CREATE;
         this.mothed = mothed;
         this.executer = executer;
         this.responder = responder;
         this.resendTime = 0;
         this.parameters = parameters;
     }

}
