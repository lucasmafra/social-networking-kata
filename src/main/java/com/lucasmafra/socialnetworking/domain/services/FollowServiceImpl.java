package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Follow;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;

public class FollowServiceImpl implements FollowService {

    private FollowGateway followGateway;

    public FollowServiceImpl(FollowGateway followGateway) {
        this.followGateway = followGateway;
    }

    @Override
    public void followUser(String follower, String userToFollow) {
        Follow follow = createFollowFrom(follower, userToFollow);
        followGateway.saveFollow(follow);
    }

    private Follow createFollowFrom(String follower, String userToFollow) {
        return new Follow(follower, userToFollow);
    }


}
