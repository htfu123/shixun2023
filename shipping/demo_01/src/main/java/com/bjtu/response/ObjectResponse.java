package com.bjtu.response;

public class ObjectResponse {
    private Object data;

    public ObjectResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
