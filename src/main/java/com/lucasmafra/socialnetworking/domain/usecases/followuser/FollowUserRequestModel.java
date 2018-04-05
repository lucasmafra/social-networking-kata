package com.lucasmafra.socialnetworking.domain.usecases.followuser;

public class FollowUserRequestModel {

    private String follower;
    private String userToFollow;

    public FollowUserRequestModel(String follower, String userToFollow) {
        this.follower = follower;
        this.userToFollow = userToFollow;
    }

    public String getFollower() {
        return follower;
    }

    public String getUserToFollow() {
        return userToFollow;
    }
}
