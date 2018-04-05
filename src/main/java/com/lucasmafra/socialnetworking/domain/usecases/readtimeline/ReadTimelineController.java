package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public class ReadTimelineController {

    private ReadTimelineRequestModel parsedInput;
    private ReadTimelineInputBoundary useCase;
    private ReadTimelineOutputBoundary presenter;
    private ReadTimelineView view;

    public ReadTimelineController(
            ReadTimelineRequestModel parsedInput,
            ReadTimelineInputBoundary useCase,
            ReadTimelineOutputBoundary presenter,
            ReadTimelineView view
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.view = view;
    }

    public void control() {
        useCase.readTimeline(parsedInput, presenter);
        view.generateView(presenter.getViewModel());
    }

}