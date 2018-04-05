package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelinePresenter;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallOutputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallPresenter;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;
import com.lucasmafra.socialnetworking.infrastructure.console.views.ReadTimelineConsoleView;
import com.lucasmafra.socialnetworking.infrastructure.console.views.ReadWallConsoleView;

import java.util.ArrayList;
import java.util.List;

public class HandlersFactory {

    private AppContext context;

    public HandlersFactory(AppContext context) {
        this.context = context;
    }

    public List<BaseHandler> createHandlers() {
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
        ReadTimelineConsoleView view = new ReadTimelineConsoleView(context.getPrintStream());
        return new ReadTimelineHandler(context, presenter, view);
    }

    private BaseHandler createReadWallHandler() {
        ReadWallOutputBoundary presenter = new ReadWallPresenter(context.getClock());
        ReadWallConsoleView view = new ReadWallConsoleView(context.getPrintStream());
        return new ReadWallHandler(context, presenter, view);
    }
}
