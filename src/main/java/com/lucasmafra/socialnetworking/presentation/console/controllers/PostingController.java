package com.lucasmafra.socialnetworking.presentation.console.controllers;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.usecases.posting.PostingInputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.posting.PostingInteractor;
import com.lucasmafra.socialnetworking.domain.usecases.posting.PostingRequestModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostingController implements Controller {

    private static final String USER_ID = "^(\\w+)";
    private static final String SEPARATOR = " -> ";
    private static final String MESSAGE = "(.*)$";

    private static final Pattern INPUT_REGEX = Pattern.compile(USER_ID + SEPARATOR + MESSAGE);

    private PostGateway postGateway;

    public PostingController(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public boolean canHandle(String input) {
        return INPUT_REGEX.matcher(input).matches();
    }

    @Override
    public void handle(String input) {
        PostingInputBoundary useCase = new PostingInteractor(this.postGateway);
        PostingRequestModel request = parseInput(input);
        useCase.publishMessageToPersonalTimeline(request);
    }

    private PostingRequestModel parseInput(String input) {
        Matcher matcher = INPUT_REGEX.matcher(input);
        matcher.matches();
        String userId = matcher.group(1);
        String message = matcher.group(2);
        return new PostingRequestModel(userId, message);
    }

}
