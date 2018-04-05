package com.lucasmafra.socialnetworking.domain.usecases.post;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;

public class PostController implements Controller {

    private PostRequestModel parsedInput;
    private PostInputBoundary useCase;

    public PostController(
            PostRequestModel parsedInput,
            PostInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    @Override
    public void control() {
        useCase.post(parsedInput);
    }

}
