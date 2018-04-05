package com.lucasmafra.socialnetworking.domain.usecases.follow;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;

public class FollowController implements Controller {

    private FollowRequestModel parsedInput;
    private FollowInputBoundary useCase;

    public FollowController(
            FollowRequestModel parsedInput,
            FollowInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    @Override
    public void control() {
        useCase.follow(parsedInput);
    }

}
