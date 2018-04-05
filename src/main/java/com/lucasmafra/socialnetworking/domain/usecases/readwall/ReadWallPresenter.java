package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import com.lucasmafra.socialnetworking.domain.utilities.Clock;

import java.util.List;
import java.util.stream.Collectors;

import static com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel.PostItem;
import static com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallViewModel.ViewablePost;
import static com.lucasmafra.socialnetworking.domain.utilities.ElapsedTimeFormatter.format;

public class ReadWallPresenter implements ReadWallOutputBoundary {

    private Clock clock;
    private ReadWallViewModel viewModel;

    public ReadWallPresenter(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void present(ReadWallResponseModel response) {
        List<ViewablePost> wall =
                response.getWall().stream()
                        .map(postItem -> makeViewablePost(postItem))
                        .collect(Collectors.toList());
        this.viewModel = new ReadWallViewModel(wall);
    }

    @Override
    public ReadWallViewModel getViewModel() {
        return viewModel;
    }

    private ViewablePost makeViewablePost(PostItem postItem) {
        return new ViewablePost(postItem.getAuthor(), postItem.getMessage(), format(postItem.getCreationDate(), clock.now()));
    }
}
