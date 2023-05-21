package com.bjtu.request;

public class RegisterRequest {
    private String username;
    private String password;
    private int identity;
    private double phone;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, int identity, double phone) {
        this.username = username;
        this.password = password;
        this.identity = identity;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }
}
