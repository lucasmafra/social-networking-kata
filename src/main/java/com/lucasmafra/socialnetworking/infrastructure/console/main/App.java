package com.lucasmafra.socialnetworking.infrastructure.console.main;

import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineOutputBoundary;
import com.lucasmafra.socialnetworking.infrastructure.console.handlers.*;
import com.lucasmafra.socialnetworking.infrastructure.console.presenters.ReadTimelinePresenter;
import com.lucasmafra.socialnetworking.infrastructure.console.views.ReadTimelineViewController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App {

    private AppContext context;
    private HandlerMatcher handlerMatcher;
    private String COMMAND_PREFIX = "> ";

    public static void main(String[] args) {
        App app = new App(AppContext.getInstance());
        app.start();
    }

    public App(AppContext context) {
        this.context = context;
        handlerMatcher = createHandlerMatcher();
    }

    public void processInput() {
        try {
            context.getPrintStream().print(COMMAND_PREFIX);
            String input = context.getBufferedReader().readNextLine();
            Handler handler = handlerMatcher.match(input);
            handler.handle(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        while (true) {
            processInput();
        }
    }

    private HandlerMatcher createHandlerMatcher() {
        List<Handler> handlers = createHandlers();
        return new HandlerMatcher(handlers);
    }

    private List<Handler> createHandlers() {
        List<Handler> handlers = new ArrayList<>();
        handlers.add(createPostHandler());
        handlers.add(createReadTimelineHandler());
        handlers.add(createFollowHandler());
        return handlers;
    }

    private Handler createPostHandler() {
        return new PostHandler(context);
    }

    private Handler createReadTimelineHandler() {
        ReadTimelineOutputBoundary presenter = new ReadTimelinePresenter(context.getClock());
        ReadTimelineViewController view = new ReadTimelineViewController(context.getPrintStream());
        return new ReadTimelineHandler(context, presenter, view);
    }

    private Handler createFollowHandler() { return new FollowHandler(context); }

}
