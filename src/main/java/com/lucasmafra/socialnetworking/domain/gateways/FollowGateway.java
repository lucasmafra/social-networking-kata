package com.lucasmafra.socialnetworking.domain.gateways;

import java.util.List;

public interface FollowGateway {
    List<String> getFollowingUsersFor(String userId);
}
