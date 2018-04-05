package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.services.WallService;
import com.lucasmafra.socialnetworking.infrastructure.data.InMemoryWallService;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.*;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWallHandler implements Handler {

    private AppContext context;
    private ReadWallOutputBoundary presenter;
    private View view;

    private static final String USER_ID = "^(\\w+)";
    private static final String ACTION = " wall$";
    private static final Pattern INPUT_PATTERN = Pattern.compile(USER_ID + ACTION);

    public ReadWallHandler(AppContext context, ReadWallOutputBoundary presenter, View view) {
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
        FollowGateway followGateway = context.getFollowGateway();
        WallService wallService = new InMemoryWallService(postGateway, followGateway);
        ReadWallInputBoundary useCase = new ReadWallInteractor(wallService);
        ReadWallController controller = new ReadWallController(parseInput(input), useCase, presenter, view);
        controller.control();
    }

    private ReadWallRequestModel parseInput(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        matcher.matches();
        String userId = matcher.group(1);
        return new ReadWallRequestModel(userId);
    }
}
