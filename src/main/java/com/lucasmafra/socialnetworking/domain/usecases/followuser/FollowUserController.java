package com.lucasmafra.socialnetworking.domain.usecases.followuser;

public class FollowUserController {

    private FollowUserRequestModel parsedInput;
    private FollowUserInputBoundary useCase;

    public FollowUserController(
            FollowUserRequestModel parsedInput,
            FollowUserInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    public void control() {
        useCase.follow(parsedInput);
    }

}
