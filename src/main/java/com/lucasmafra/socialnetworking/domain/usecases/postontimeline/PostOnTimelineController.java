package com.lucasmafra.socialnetworking.domain.usecases.postontimeline;

public class PostOnTimelineController {

    private PostOnTimelineRequestModel parsedInput;
    private PostOnTimelineInputBoundary useCase;

    public PostOnTimelineController(
            PostOnTimelineRequestModel parsedInput,
            PostOnTimelineInputBoundary useCase
    ) {
        this.useCase = useCase;
        this.parsedInput = parsedInput;
    }

    public void control() {
        useCase.post(parsedInput);
    }

}
