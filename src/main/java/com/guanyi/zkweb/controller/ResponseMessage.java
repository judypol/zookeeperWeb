package com.guanyi.zkweb.controller;

public class ResponseMessage {
    boolean success;
    String msg;
    Object data;

    public ResponseMessage(boolean success,String msg,Object data){
        this.success=success;
        this.msg=msg;
        this.data=data;
    }
    public ResponseMessage(String msg){
        this.success=false;
        this.msg=msg;
    }
    public ResponseMessage(Object data){
        this.success=true;
        this.data=data;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
