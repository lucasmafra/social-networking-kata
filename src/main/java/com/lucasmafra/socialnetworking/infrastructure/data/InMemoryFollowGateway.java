package com.lucasmafra.socialnetworking.infrastructure.data;

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
    public void saveFollow(String follower, String followed) {
        List<String> currentFollowing = followMap.get(follower);
        if (currentFollowing == null) {
            currentFollowing = new ArrayList<>();
        }
        currentFollowing.add(followed);
        followMap.put(follower, currentFollowing);
    }
}
