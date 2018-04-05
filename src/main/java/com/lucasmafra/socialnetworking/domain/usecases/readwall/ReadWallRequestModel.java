package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public class ReadWallRequestModel {

    private String user;

    public ReadWallRequestModel(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
