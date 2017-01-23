package com.example.dell.socialcampus.manager.messageDistribute;

import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;

/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage {
    //枚举变量容易造成内存泄漏
    public enum Error{
        MESSAGE_ERROR_NORESPONDER,MESSAGE_ERROR_RUNTIME
    }

    private SCMothed        mothed;              //消息类型
    private SCLinkedMap     parameters;          //携带的数据
    private SCIResponder    responder;           //响应者(接受者，消息的消费)
    private SCIResponder    executer;            //执行者(调用者，消息的产生)
    private Error           error;               //错误域
    private Exception       errorCause;          //错误原因

    /**
     * 类似JavaBean
     */
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
    public SCMothed getMothed(){
        return mothed;
    }


    /**
     * 构造函数
     */
    public SCMessage(SCMothed mothed, SCIResponder executer, SCLinkedMap parameters){
        init(mothed, executer, parameters);
    }
    /**
     * 初始化函数
     */
    public void init(SCMothed mothed, SCIResponder executer, SCLinkedMap parameters){
        this.mothed     = mothed;
        this.executer   = executer;
        this.responder  = SCMothed.returnResponder(mothed);
        this.parameters = parameters;
        this.error      = null;
        this.errorCause = null;

    }

}
