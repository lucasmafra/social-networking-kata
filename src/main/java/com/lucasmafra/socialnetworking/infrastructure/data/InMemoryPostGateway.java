package com.lucasmafra.socialnetworking.infrastructure.data;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.Clock;

import java.util.ArrayList;
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
    public List<Post> getPostsInReverseChronologicalOrderFor(String user) {
        return posts.stream()
                .filter( post -> post.getUser().equals(user))
                .sorted(comparing(Post::getCreatedDate).reversed())
                .collect(toList());
    }

    @Override
    public void savePost(Post post) {
        posts.add(post);
    }

}
