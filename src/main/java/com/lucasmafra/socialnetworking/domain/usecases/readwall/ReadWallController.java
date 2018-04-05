package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;
import com.lucasmafra.socialnetworking.domain.usecases.View;

public class ReadWallController implements Controller {

    private ReadWallRequestModel parsedInput;
    private ReadWallInputBoundary useCase;
    private ReadWallOutputBoundary presenter;
    private View view;

    public ReadWallController(
            ReadWallRequestModel parsedInput,
            ReadWallInputBoundary useCase,
            ReadWallOutputBoundary presenter,
            View view
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void control() {
        useCase.readWall(parsedInput, presenter);
        view.generateView(presenter.getViewModel());
    }

}