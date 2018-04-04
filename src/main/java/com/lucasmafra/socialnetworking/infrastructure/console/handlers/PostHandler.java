package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.usecases.post.PostController;
import com.lucasmafra.socialnetworking.domain.usecases.post.PostInputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.post.PostInteractor;
import com.lucasmafra.socialnetworking.domain.usecases.post.PostRequestModel;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostHandler implements Handler {

    private AppContext context;
    private static final String USER_ID = "^(\\w+)";
    private static final String SEPARATOR = " -> ";
    private static final String MESSAGE = "(.*)$";

    private static final Pattern INPUT_PATTERN = Pattern.compile(USER_ID + SEPARATOR + MESSAGE);

    public PostHandler(AppContext context) {
        this.context = context;
    }

    @Override
    public boolean canHandle(String input) {
        return INPUT_PATTERN.matcher(input).matches();
    }

    @Override
    public void handle(String input) {
        PostGateway postGateway = context.getPostGateway();
        PostInputBoundary useCase = new PostInteractor(postGateway);
        PostController controller = new PostController(parseInput(input), useCase);
        controller.control();
    }

    private PostRequestModel parseInput(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        matcher.matches();
        String userId = matcher.group(1);
        String message = matcher.group(2);
        return new PostRequestModel(userId, message);
    }
}
