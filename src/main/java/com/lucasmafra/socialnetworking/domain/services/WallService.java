package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Post;

import java.util.List;

public interface WallService {
    List<Post> getWallPostsInReverseChronologicalOrderFor(String user);
}
