package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.services.TimelineService;
import com.lucasmafra.socialnetworking.domain.services.TimelineServiceImpl;
import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.*;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTimelineHandler extends BaseHandler {

    private AppContext context;
    private ReadTimelineOutputBoundary presenter;
    private View view;

    public ReadTimelineHandler(AppContext context, ReadTimelineOutputBoundary presenter, View view) {
        this.context = context;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void handle(String input) {
        TimelineService timelineService = createTimelineService();
        ReadTimelineInputBoundary useCase = new ReadTimelineInteractor(timelineService);
        ReadTimelineController controller = new ReadTimelineController(parseInput(input), useCase, presenter, view);
        controller.control();
    }

    @Override
    Pattern getInputPattern() {
        return context.getCommands().getReadTimelineCommandPattern();
    }

    private ReadTimelineRequestModel parseInput(String input) {
        Matcher matcher = getInputPattern().matcher(input);
        matcher.matches();
        String user = matcher.group(1);
        return new ReadTimelineRequestModel(user);
    }

    private TimelineServiceImpl createTimelineService() {
        return new TimelineServiceImpl(context.getPostGateway(), context.getClock());
    }
}
