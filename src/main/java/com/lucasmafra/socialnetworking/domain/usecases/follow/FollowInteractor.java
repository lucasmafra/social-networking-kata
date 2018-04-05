package com.lucasmafra.socialnetworking.domain.usecases.follow;

import com.lucasmafra.socialnetworking.domain.entities.Follow;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;

public class FollowInteractor implements FollowInputBoundary {

    private FollowGateway followGateway;

    public FollowInteractor(FollowGateway followGateway) {
        this.followGateway = followGateway;
    }

    @Override
    public void follow(FollowRequestModel request) {
        this.followGateway.saveFollow(new Follow(request.getFollower(), request.getFollowing()));
    }
}
