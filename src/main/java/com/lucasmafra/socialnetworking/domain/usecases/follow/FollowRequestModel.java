package com.lucasmafra.socialnetworking.domain.usecases.follow;

public class FollowRequestModel {

    private String follower;
    private String following;

    public FollowRequestModel(String follower, String following) {
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
