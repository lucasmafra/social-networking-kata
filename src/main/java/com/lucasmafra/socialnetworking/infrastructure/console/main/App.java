package com.lucasmafra.socialnetworking.infrastructure.console.main;

import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallOutputBoundary;
import com.lucasmafra.socialnetworking.infrastructure.console.handlers.*;
import com.lucasmafra.socialnetworking.infrastructure.console.presenters.ReadTimelinePresenter;
import com.lucasmafra.socialnetworking.infrastructure.console.presenters.ReadWallPresenter;
import com.lucasmafra.socialnetworking.infrastructure.console.views.ReadTimelineView;
import com.lucasmafra.socialnetworking.infrastructure.console.views.ReadWallView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    private AppContext context;
    private HandlerMatcher handlerMatcher;
    private String NEW_LINE_PREFIX = "> ";

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
            context.getPrintStream().print(NEW_LINE_PREFIX);
            String input = context.getBufferedReader().readNextLine();
            BaseHandler handler = handlerMatcher.match(input);
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
        List<BaseHandler> handlers = createHandlers();
        return new HandlerMatcher(handlers);
    }

    private List<BaseHandler> createHandlers() {
        List<BaseHandler> handlers = new ArrayList<>();
        handlers.add(createPostHandler());
        handlers.add(createFollowHandler());
        handlers.add(createReadTimelineHandler());
        handlers.add(createReadWallHandler());
        return handlers;
    }

    private BaseHandler createPostHandler() {
        return new PostOnTimelineHandler(context);
    }

    private BaseHandler createFollowHandler() {
        return new FollowUserHandler(context);
    }

    private BaseHandler createReadTimelineHandler() {
        ReadTimelineOutputBoundary presenter = new ReadTimelinePresenter(context.getClock());
        ReadTimelineView view = new ReadTimelineView(context.getPrintStream());
        return new ReadTimelineHandler(context, presenter, view);
    }

    private BaseHandler createReadWallHandler() {
        ReadWallOutputBoundary presenter = new ReadWallPresenter(context.getClock());
        ReadWallView view = new ReadWallView(context.getPrintStream());
        return new ReadWallHandler(context, presenter, view);
    }

}
