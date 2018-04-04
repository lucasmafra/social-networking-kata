package com.lucasmafra.socialnetworking.infrastructure.data;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.infrastructure.Clock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class InMemoryPostGateway implements PostGateway {

    private Clock clock;
    private List<Post> posts = new ArrayList<>();

    public InMemoryPostGateway(Clock clock) {
        this.clock = clock;
    }

    @Override
    public List<Post> getPostsInReverseChronologicalOrder(String userId) {
        return posts.stream()
                .filter( post -> post.getUserId().equals(userId))
                .sorted(comparing(Post::getCreatedDate).reversed())
                .collect(toList());
    }

    @Override
    public void savePost(String userId, String message) {
        Post post = createPostFrom(userId, message);
        posts.add(post);
    }

    private Post createPostFrom(String userId, String message) {
        Date creationDate = clock.now();
        return new Post(userId, message, creationDate);
    }

}
