package com.lucasmafra.socialnetworking.infrastructure.console.presenters;

import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineResponseModel;
import com.lucasmafra.socialnetworking.infrastructure.Clock;
import com.lucasmafra.socialnetworking.infrastructure.console.utilities.ElapsedTimeFormatter;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadTimelineViewModel;

import java.util.List;

import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadTimelineViewModel.*;
import static java.util.stream.Collectors.toList;

public class ReadTimelinePresenter implements ReadTimelineOutputBoundary<ReadTimelineViewModel> {

    private ReadTimelineViewModel viewModel;
    private Clock clock;
    private ElapsedTimeFormatter timeFormatter;

    public ReadTimelinePresenter(Clock clock) {
        this.clock = clock;
        this.timeFormatter= new ElapsedTimeFormatter();
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
        List<ViewablePost> timeline = response.getTimeline()
                                      .stream()
                                      .map( postItem -> new ViewablePost(postItem.getMessage(), timeFormatter.format(postItem.getCreationDate(), clock.now())))
                                      .collect(toList());

        return new ReadTimelineViewModel(timeline);
    }

}
