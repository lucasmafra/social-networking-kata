package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;

public class WallServiceImpl implements WallService {

    private PostGateway postGateway;
    private FollowGateway followGateway;

    public WallServiceImpl(PostGateway postGateway, FollowGateway followGateway) {
        this.postGateway = postGateway;
        this.followGateway = followGateway;
    }

    @Override
    public List<Post> getWallPostsInReverseChronologicalOrderFor(String userId) {
        List<Post> authorPosts = postGateway.getPostsInReverseChronologicalOrder(userId);
        List<Post> followingUsersPosts = getFollowingUsersPostFor(userId);
        return combinePostsInReverseChronologicalOrder(authorPosts, followingUsersPosts);
    }

    private List<Post> getFollowingUsersPostFor(String userId) {
        List<String> followingUsers = followGateway.getFollowingUsersFor(userId);
        List<Post> followingUsersPost = new ArrayList<>();
        followingUsers.stream()
               .forEach(followingUser-> {
                   List<Post> userPosts = postGateway.getPostsInReverseChronologicalOrder(followingUser);
                   followingUsersPost.addAll(userPosts);
               });
        return followingUsersPost;
    }

    private List<Post> combinePostsInReverseChronologicalOrder(List<Post> authorPosts, List<Post> followingUsersPosts) {
        List<Post> combinedPosts = new ArrayList<>(authorPosts);
        combinedPosts.addAll(followingUsersPosts);
        combinedPosts.sort(comparing(Post::getCreatedDate).reversed());
        return combinedPosts;
    }

}
