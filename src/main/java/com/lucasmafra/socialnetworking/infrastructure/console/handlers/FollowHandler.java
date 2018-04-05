package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;
import com.lucasmafra.socialnetworking.domain.usecases.follow.FollowController;
import com.lucasmafra.socialnetworking.domain.usecases.follow.FollowInputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.follow.FollowInteractor;
import com.lucasmafra.socialnetworking.domain.usecases.follow.FollowRequestModel;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FollowHandler extends BaseHandler {

    private AppContext context;

    public FollowHandler(AppContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        FollowGateway followGateway = context.getFollowGateway();
        FollowInputBoundary useCase = new FollowInteractor(followGateway);
        FollowController controller = new FollowController(parseInput(input), useCase);
        controller.control();
    }

    @Override
    Pattern getInputPattern() {
        return context.getCommands().getFollowCommandPattern();
    }

    private FollowRequestModel parseInput(String input) {
        Matcher matcher = getInputPattern().matcher(input);
        matcher.matches();
        String followerId = matcher.group(1);
        String followedId = matcher.group(2);
        return new FollowRequestModel(followerId, followedId);
    }

}
