package com.lucasmafra.socialnetworking.domain.gateways;

import com.lucasmafra.socialnetworking.domain.entities.Follow;

import java.util.List;

public interface FollowGateway {
    List<String> getFollowingUsersFor(String user);

    void saveFollow(Follow follow);
}
