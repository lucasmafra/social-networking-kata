package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public interface ReadTimelineOutputBoundary {

    void present(ReadTimelineResponseModel response);

    ReadTimelineViewModel getViewModel();

}
