package com.lucasmafra.socialnetworking.infrastructure.console.presenters;

import com.lucasmafra.socialnetworking.domain.Clock;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel;

import java.util.List;
import java.util.stream.Collectors;

import static com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallResponseModel.PostItem;
import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel.ViewablePost;
import static com.lucasmafra.socialnetworking.infrastructure.utilities.ElapsedTimeFormatter.format;

public class ReadWallPresenter implements ReadWallOutputBoundary<ReadWallViewModel> {

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
