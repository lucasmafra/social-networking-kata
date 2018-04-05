package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public class ReadWallController {

    private ReadWallRequestModel parsedInput;
    private ReadWallInputBoundary useCase;
    private ReadWallOutputBoundary presenter;
    private ReadWallView view;

    public ReadWallController(
            ReadWallRequestModel parsedInput,
            ReadWallInputBoundary useCase,
            ReadWallOutputBoundary presenter,
            ReadWallView view
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.view = view;
    }

    public void control() {
        useCase.readWall(parsedInput, presenter);
        view.generateView(presenter.getViewModel());
    }

}