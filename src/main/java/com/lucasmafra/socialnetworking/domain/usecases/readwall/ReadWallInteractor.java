package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.services.WallService;

import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel.*;
import static java.util.stream.Collectors.toList;

public class ReadWallInteractor implements ReadWallInputBoundary {

    private WallService wallService;

    public ReadWallInteractor(WallService wallService) {
        this.wallService = wallService;
    }

    @Override
    public void readWall(ReadWallRequestModel request, ReadWallOutputBoundary presenter) {
        List<Post> posts = this.wallService.getWallFor(request.getUser());
        ReadWallResponseModel response = mapToResponse(posts);
        presenter.present(response);
    }

    private ReadWallResponseModel mapToResponse(List<Post> posts) {
        List<PostResponse> postsResponse = posts.stream()
                                                .map(post -> new PostResponse(post.getUser(), post.getMessage(), post.getCreatedDate()))
                                                .collect(toList());
        return new ReadWallResponseModel(postsResponse);
    }
}
