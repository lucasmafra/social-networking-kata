package com.lucasmafra.socialnetworking.domain.usecases.postontimeline;

import com.lucasmafra.socialnetworking.domain.usecases.Controller;

public class PostOnTimelineController implements Controller {

    private PostOnTimelineRequestModel parsedInput;
    private PostOnTimelineInputBoundary useCase;

    public PostOnTimelineController(
            PostOnTimelineRequestModel parsedInput,
            PostOnTimelineInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    @Override
    public void control() {
        useCase.post(parsedInput);
    }

}
