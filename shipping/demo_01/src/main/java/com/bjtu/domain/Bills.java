package com.bjtu.domain;

import java.util.Date;

public class Bills {
    private int id;
    private int order_id;
    private int carrier_id;
    private String location;
    private int time;
    private double pay;

    public Bills(int order_id, int carrier_id, String location, int time, double pay) {
        this.order_id = order_id;
        this.carrier_id = carrier_id;
        this.location = location;
        this.time = time;
        this.pay = pay;
    }

    public Bills(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCarrier_id() {
        return carrier_id;
    }

    public void setCarrier_id(int carrier_id) {
        this.carrier_id = carrier_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
