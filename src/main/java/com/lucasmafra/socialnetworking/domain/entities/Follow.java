package com.lucasmafra.socialnetworking.domain.entities;

import java.util.Date;

public class Follow {

    private String follower;
    private String followed;

    public Follow(String follower, String followed) {
        this.follower = follower;
        this.followed = followed;
    }

    public String getFollower() {
        return follower;
    }

    public String getFollowed() {
        return followed;
    }
}
