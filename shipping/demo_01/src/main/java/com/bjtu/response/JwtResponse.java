package com.bjtu.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String username;
    private List<String> roles;

    public JwtResponse(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getIdentity() {
        return roles;
    }

    public void setIdentity(List<String> roles) {
        this.roles = roles;
    }
}
