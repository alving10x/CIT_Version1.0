package com.projects.CIT_Version1_0.model;

public class LoginResponse {
    private String returnUrl;

    public LoginResponse(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    public String getReturnUrl() {
        return returnUrl;
    }
}

