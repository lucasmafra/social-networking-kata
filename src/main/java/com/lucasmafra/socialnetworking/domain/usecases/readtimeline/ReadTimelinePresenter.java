package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.utilities.Clock;

import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineResponseModel.*;
import static com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineViewModel.ViewablePost;
import static com.lucasmafra.socialnetworking.domain.utilities.ElapsedTimeFormatter.format;
import static java.util.stream.Collectors.toList;

public class ReadTimelinePresenter implements ReadTimelineOutputBoundary {

    private ReadTimelineViewModel viewModel;
    private Clock clock;

    public ReadTimelinePresenter(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void present(ReadTimelineResponseModel response) {
        viewModel = makeViewable(response);
    }

    @Override
    public ReadTimelineViewModel getViewModel() {
        return viewModel;
    }

    private ReadTimelineViewModel makeViewable(ReadTimelineResponseModel response) {
        List<ViewablePost> timeline = response.getPosts()
                                              .stream()
                                              .map(postItem -> makeViewablePost(postItem))
                                              .collect(toList());
        return new ReadTimelineViewModel(timeline);
    }

    private ViewablePost makeViewablePost(PostResponse postItem) {
        return new ViewablePost(postItem.getMessage(), format(postItem.getCreationDate(), clock.now()));
    }

}
