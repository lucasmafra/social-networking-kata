package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.*;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTimelineHandler implements Handler {

    private AppContext context;
    private ReadTimelineOutputBoundary presenter;
    private View view;

    private static final String USER_ID = "^(\\w+)";
    private static final Pattern INPUT_PATTERN = Pattern.compile(USER_ID);

    public ReadTimelineHandler(AppContext context, ReadTimelineOutputBoundary presenter, View view) {
        this.context = context;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public boolean canHandle(String input) {
        return INPUT_PATTERN.matcher(input).matches();
    }

    @Override
    public void handle(String input) {
        PostGateway postGateway = context.getPostGateway();
        ReadTimelineInputBoundary useCase = new ReadTimelineInteractor(postGateway);
        ReadTimelineController controller = new ReadTimelineController(parseInput(input), useCase, presenter, view);
        controller.control();
    }

    private ReadTimelineRequestModel parseInput(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        matcher.matches();
        String userId = matcher.group(1);
        return new ReadTimelineRequestModel(userId);
    }
}
