package com.bjtu.response;

import java.util.List;

public class ListResponse {
    private List<?> list;

    public ListResponse(List<?> list) {
        this.list = list;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
