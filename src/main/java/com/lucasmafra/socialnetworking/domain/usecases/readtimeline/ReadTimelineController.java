package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.controller.Controller;
import com.lucasmafra.socialnetworking.domain.controller.ViewController;

public class ReadTimelineController implements Controller {

    private ReadTimelineRequestModel parsedInput;
    private ReadTimelineInputBoundary useCase;
    private ReadTimelineOutputBoundary presenter;
    private ViewController viewController;

    public ReadTimelineController(
            ReadTimelineRequestModel parsedInput,
            ReadTimelineInputBoundary useCase,
            ReadTimelineOutputBoundary presenter,
            ViewController viewController
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.viewController = viewController;
    }

    @Override
    public void control() {
        useCase.readTimeline(parsedInput, presenter);
        viewController.generateView(presenter.getViewModel());
    }

}