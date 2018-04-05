package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;
import com.lucasmafra.socialnetworking.domain.usecases.View;

public class ReadTimelineController implements Controller {

    private ReadTimelineRequestModel parsedInput;
    private ReadTimelineInputBoundary useCase;
    private ReadTimelineOutputBoundary presenter;
    private View view;

    public ReadTimelineController(
            ReadTimelineRequestModel parsedInput,
            ReadTimelineInputBoundary useCase,
            ReadTimelineOutputBoundary presenter,
            View view
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void control() {
        useCase.readTimeline(parsedInput, presenter);
        view.generateView(presenter.getViewModel());
    }

}