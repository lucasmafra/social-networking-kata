package com.lucasmafra.socialnetworking.domain.entities;

public class Follow {

    private String follower;
    private String following;

    public Follow(String follower, String following) {
        this.follower = follower;
        this.following = following;
    }

    public String getFollower() {
        return follower;
    }

    public String getFollowing() {
        return following;
    }
}
