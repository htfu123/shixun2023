package com.bjtu.domain;

public class Order {
    private int id;
    private String goods_name;
    private int num;
    private String start;
    private String end;
    private int user_id;

    public Order(){

    }
    public Order(String goods_name, int num, String start, String end, int user_id) {
        this.goods_name = goods_name;
        this.num = num;
        this.start = start;
        this.end = end;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
