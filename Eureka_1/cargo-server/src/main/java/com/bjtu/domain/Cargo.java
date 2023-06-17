package com.bjtu.domain;

import java.util.Date;

public class Cargo {
    private int cargo_id;
    private String cargo_name;
    private String cargo_start;
    private String cargo_end;
    private int cargo_num;
    private Date cargo_time=new Date();
//    private SimpleDateFormat cargo_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String cargo_owner;
    private String cargo_status;

    public Cargo() { }

    public Cargo(String cargo_name, String cargo_start, String cargo_end, int cargo_num, String cargo_owner) {
        this.cargo_name = cargo_name;
        this.cargo_start = cargo_start;
        this.cargo_end = cargo_end;
        this.cargo_num = cargo_num;
        this.cargo_owner = cargo_owner;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargo_id=" + cargo_id +
                ", cargo_name='" + cargo_name + '\'' +
                ", cargo_start='" + cargo_start + '\'' +
                ", cargo_end='" + cargo_end + '\'' +
                ", cargo_num=" + cargo_num +
                ", cargo_time=" + cargo_time +
                ", cargo_owner='" + cargo_owner + '\'' +
                ", cargo_status='" + cargo_status + '\'' +
                '}';
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    public String getCargo_start() {
        return cargo_start;
    }

    public void setCargo_start(String cargo_start) {
        this.cargo_start = cargo_start;
    }

    public String getCargo_end() {
        return cargo_end;
    }

    public void setCargo_end(String cargo_end) {
        this.cargo_end = cargo_end;
    }

    public int getCargo_num() {
        return cargo_num;
    }

    public void setCargo_num(int cargo_num) {
        this.cargo_num = cargo_num;
    }

    public Date getCargo_time() {
        return cargo_time;
    }

    public void setCargo_time(Date cargo_time) {
        this.cargo_time = cargo_time;
    }

    public String getCargo_owner() {
        return cargo_owner;
    }

    public void setCargo_owner(String cargo_owner) {
        this.cargo_owner = cargo_owner;
    }

    public String getCargo_status() {
        return cargo_status;
    }

    public void setCargo_status(String cargo_status) {
        this.cargo_status = cargo_status;
    }
}
