package com.lucasmafra.socialnetworking.domain.usecases.followuser;

import com.lucasmafra.socialnetworking.domain.services.FollowService;

public class FollowUserInteractor implements FollowUserInputBoundary {

    private FollowService followService;

    public FollowUserInteractor(FollowService followService) {
        this.followService = followService;
    }

    @Override
    public void follow(FollowUserRequestModel request) {
        this.followService.followUser(request.getFollower(), request.getUserToFollow());
    }
}
