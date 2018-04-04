package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import java.util.List;

public class HandlerMatcher {

    private List<Handler> handlers;

    public HandlerMatcher(List<Handler> handlers) {
        this.handlers= handlers;
    }

    public Handler match(String input) {
        for (Handler handler: handlers) {
            if (handler.canHandle(input)) {
                return handler;
            }
        }
        return new DefaultHandler();
    }

}
