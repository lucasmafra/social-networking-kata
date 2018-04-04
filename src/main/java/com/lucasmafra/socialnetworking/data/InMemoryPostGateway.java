package com.lucasmafra.socialnetworking.data;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

import java.util.List;

public class InMemoryPostGateway implements PostGateway {

    private Clock clock;

    public InMemoryPostGateway(Clock clock) {
        this.clock = clock;
    }

    @Override
    public List<Post> getPostsInReverseChronologicalOrder(String userId) {
        return null;
    }
}
