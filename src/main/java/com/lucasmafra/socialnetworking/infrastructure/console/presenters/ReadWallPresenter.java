package com.lucasmafra.socialnetworking.infrastructure.console.presenters;

import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel;
import com.lucasmafra.socialnetworking.infrastructure.Clock;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel;

import java.util.List;
import java.util.stream.Collectors;

import static com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel.*;
import static com.lucasmafra.socialnetworking.infrastructure.console.utilities.ElapsedTimeFormatter.format;
import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel.*;

public class ReadWallPresenter implements ReadWallOutputBoundary<ReadWallViewModel> {

    private Clock clock;
    private ReadWallViewModel viewModel;

    public ReadWallPresenter(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void present(ReadWallResponseModel response) {
        List<PostItem> wallPosts = response.getWall();
        List<ViewablePost> viewablePosts =
                wallPosts.stream()
                        .map(postItem -> makeViewablePost(postItem))
                        .collect(Collectors.toList());
        this.viewModel = new ReadWallViewModel(viewablePosts);
    }

    @Override
    public ReadWallViewModel getViewModel() {
        return viewModel;
    }

    private ViewablePost makeViewablePost(PostItem postItem) {
        return new ViewablePost(postItem.getAuthor(), postItem.getMessage(), format(postItem.getCreationDate(), clock.now()));
    }
}
