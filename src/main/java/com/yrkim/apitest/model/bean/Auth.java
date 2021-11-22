package com.yrkim.apitest.model.bean;

public enum Auth {
    ADMIN,
    MANAGER,
    USER;

    public String getAuth_Name(){
        return "ROLE_"+this.name();
    }
}
