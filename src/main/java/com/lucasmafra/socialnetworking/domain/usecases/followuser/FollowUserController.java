package com.lucasmafra.socialnetworking.domain.usecases.followuser;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;

public class FollowUserController implements Controller {

    private FollowUserRequestModel parsedInput;
    private FollowUserInputBoundary useCase;

    public FollowUserController(
            FollowUserRequestModel parsedInput,
            FollowUserInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    @Override
    public void control() {
        useCase.follow(parsedInput);
    }

}
