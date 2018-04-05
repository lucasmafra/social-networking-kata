package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public class ReadWallRequestModel {

    private String userId;

    public ReadWallRequestModel(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
