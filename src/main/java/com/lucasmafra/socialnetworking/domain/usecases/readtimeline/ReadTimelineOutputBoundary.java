package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public interface ReadTimelineOutputBoundary<ViewModel> {

    void present(ReadTimelineResponseModel response);

    ViewModel getViewModel();

}
