package com.java.threadSignalling.waitNotiy;

public class Message {
    private String msg;
    private boolean signalled = false;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSignalled() {
        return signalled;
    }

    public void setSignalled(boolean signalled) {
        this.signalled = signalled;
    }
}
