package com.exam.system.exam.model;

public class JwtResponse {
    private String token;

    public JwtResponse() {

    }

    public JwtResponse(String token) {
        this.token = token;
    }

    /**
     * @return String return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

}
