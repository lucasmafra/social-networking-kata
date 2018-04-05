package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.services.FollowService;
import com.lucasmafra.socialnetworking.domain.services.FollowServiceImpl;
import com.lucasmafra.socialnetworking.domain.usecases.followuser.FollowUserController;
import com.lucasmafra.socialnetworking.domain.usecases.followuser.FollowUserInputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.followuser.FollowUserInteractor;
import com.lucasmafra.socialnetworking.domain.usecases.followuser.FollowUserRequestModel;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FollowUserHandler extends BaseHandler {

    private AppContext context;

    public FollowUserHandler(AppContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        FollowService followService = createFollowService();
        FollowUserInputBoundary useCase = new FollowUserInteractor(followService);
        FollowUserController controller = new FollowUserController(parseInput(input), useCase);
        controller.control();
    }

    @Override
    Pattern getInputPattern() {
        return context.getCommands().getFollowCommandPattern();
    }

    private FollowUserRequestModel parseInput(String input) {
        Matcher matcher = getInputPattern().matcher(input);
        matcher.matches();
        String followerId = matcher.group(1);
        String followedId = matcher.group(2);
        return new FollowUserRequestModel(followerId, followedId);
    }

    private FollowService createFollowService() {
        return new FollowServiceImpl(context.getFollowGateway());
    }

}
