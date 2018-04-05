package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class WallServiceImpl implements WallService {

    private PostGateway postGateway;
    private FollowGateway followGateway;

    public WallServiceImpl(PostGateway postGateway, FollowGateway followGateway) {
        this.postGateway = postGateway;
        this.followGateway = followGateway;
    }

    @Override
    public List<Post> getWallFor(String user) {
        List<Post> ownPosts = getOwnPosts(user);
        List<Post> followingUsersPosts = getFollowingUsersPosts(user);
        return combinePostsInReverseChronologicalOrder(ownPosts, followingUsersPosts);
    }

    private List<Post> getOwnPosts(String user) {
        return postGateway.getPostsInReverseChronologicalOrderFor(user);
    }

    private List<Post> getFollowingUsersPosts(String user) {
        List<String> followingUsers = followGateway.getFollowingUsersFor(user);
        List<Post> followingUsersPost = new ArrayList<>();
        followingUsers.stream()
                .forEach(followingUser -> {
                    List<Post> userPosts = getOwnPosts(followingUser);
                    followingUsersPost.addAll(userPosts);
                });
        return followingUsersPost;
    }

    private List<Post> combinePostsInReverseChronologicalOrder(List<Post> ownPosts, List<Post> followingUsersPosts) {
        List<Post> combinedPosts = new ArrayList<>(ownPosts);
        combinedPosts.addAll(followingUsersPosts);
        combinedPosts.sort(comparing(Post::getCreatedDate).reversed());
        return combinedPosts;
    }
}
