package com.lucasmafra.socialnetworking.infrastructure.data;

import com.lucasmafra.socialnetworking.domain.entities.Follow;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFollowGateway implements FollowGateway {

    private Map<String, List<String>> followMap = new HashMap<>();

    @Override
    public List<String> getFollowingUsersFor(String userId) {
        return followMap.get(userId);
    }

    @Override
    public void saveFollow(Follow follow) {
        List<String> followingUsers = followMap.get(follow.getFollower());
        if (followingUsers == null) {
            followingUsers = new ArrayList<>();
        }
        followingUsers.add(follow.getFollowed());
        followMap.put(follow.getFollower(), followingUsers);
    }
}
