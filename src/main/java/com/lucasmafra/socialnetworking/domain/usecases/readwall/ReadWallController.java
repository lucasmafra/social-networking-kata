package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import com.lucasmafra.socialnetworking.domain.controller.Controller;
import com.lucasmafra.socialnetworking.domain.controller.ViewController;

public class ReadWallController implements Controller {

    private ReadWallRequestModel parsedInput;
    private ReadWallInputBoundary useCase;
    private ReadWallOutputBoundary presenter;
    private ViewController viewController;

    public ReadWallController(
            ReadWallRequestModel parsedInput,
            ReadWallInputBoundary useCase,
            ReadWallOutputBoundary presenter,
            ViewController viewController
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.viewController = viewController;
    }

    @Override
    public void control() {
        useCase.readWall(parsedInput, presenter);
        viewController.generateView(presenter.getViewModel());
    }

}