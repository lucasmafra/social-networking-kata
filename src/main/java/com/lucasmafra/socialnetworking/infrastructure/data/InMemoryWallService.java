package com.lucasmafra.socialnetworking.infrastructure.data;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.services.WallService;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;

public class InMemoryWallService implements WallService {

    private InMemoryPostGateway postGateway;
    private InMemoryFollowGateway followGateway;

    public InMemoryWallService(InMemoryPostGateway postGateway, InMemoryFollowGateway followGateway) {
        this.postGateway = postGateway;
        this.followGateway = followGateway;
    }

    @Override
    public List<Post> getWallPostsInReverseChronologicalOrderFor(String user) {
        List<Post> authorPosts = postGateway.getPostsInReverseChronologicalOrder(user);
        List<Post> followingUsersPosts = getFollowingUsersPostFor(user);
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
