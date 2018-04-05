package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import com.lucasmafra.socialnetworking.domain.services.TimelineService;
import com.lucasmafra.socialnetworking.domain.services.TimelineServiceImpl;
import com.lucasmafra.socialnetworking.domain.usecases.postontimeline.PostOnTimelineController;
import com.lucasmafra.socialnetworking.domain.usecases.postontimeline.PostOnTimelineInputBoundary;
import com.lucasmafra.socialnetworking.domain.usecases.postontimeline.PostOnTimelineInteractor;
import com.lucasmafra.socialnetworking.domain.usecases.postontimeline.PostOnTimelineRequestModel;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOnTimelineHandler extends BaseHandler {

    private AppContext context;

    public PostOnTimelineHandler(AppContext context) {
        this.context = context;
    }

    @Override
    public void handle(String input) {
        TimelineService timelineService = createTimelineService();
        PostOnTimelineInputBoundary useCase = new PostOnTimelineInteractor(timelineService);
        PostOnTimelineController controller = new PostOnTimelineController(parseInput(input), useCase);
        controller.control();
    }

    @Override
    Pattern getInputPattern() {
        return context.getCommands().getPostCommandPattern();
    }

    private PostOnTimelineRequestModel parseInput(String input) {
        Matcher matcher = getInputPattern().matcher(input);
        matcher.matches();
        String user = matcher.group(1);
        String message = matcher.group(2);
        return new PostOnTimelineRequestModel(user, message);
    }

    private TimelineServiceImpl createTimelineService() {
        return new TimelineServiceImpl(context.getPostGateway(), context.getClock());
    }
}
