package com.example.dell.socialcampus.Manager.MessageDistribute;

import android.util.Log;

import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage {
    //枚举变量容易造成内存泄漏
    private enum Mothed{
        QUERY,UPDATE
    }
    private enum State{
        MESSAGE_STATE_CREATE, MESSAGE_STATE_SENDING,MESSAGE_STATE_SUCCEED,
        MESSAGE_STATE_FAILED,MESSAGE_STATE_DISTROY
    }
    private enum Error{
        MESSAGE_ERROR_OVERTIME,MESSAGE_ERROR_NORESPONDER,MESSAGE_ERROR_NOUSE
    }
    private static int numberOfId = 0;

    final private int MAXTIME       = 10000;   //最大等待时间
    final private int MAXRESENDTIME = 5;       //最大重传数

    private int     messageId;           //消息ID
    private int     resendTime;          //重传次数
    private boolean isOverTime;          //是否超时
    private Mothed  mothed;              //消息类型
    private Map   parameters;          //携带的数据
    private Object  responder;           //响应者(接受者消息的消费)
    private Object  executer;            //执行者(调用者消息的产生)
    private State   state;               //状态码
    private Error   error;               //错误域

    /**
     * like JavaBean
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
    /**
     * 构造函数
     */
    public SCMessage(Mothed mothed,Object executer,Object responder){
        messageId = numberOfId;
        numberOfId++;
        state = State.MESSAGE_STATE_CREATE;
        this.mothed = mothed;
        this.executer = executer;
        this.responder = responder;
    }

}
