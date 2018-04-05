package com.lucasmafra.socialnetworking.domain.gateways;

import com.lucasmafra.socialnetworking.domain.entities.Post;

import java.util.List;

public interface PostGateway {
    List<Post> getPostsInReverseChronologicalOrder(String user);
    void savePost(String user, String message);
}
