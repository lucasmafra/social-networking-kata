package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import java.util.List;

public class HandlerMatcher {

    private List<BaseHandler> handlers;

    public HandlerMatcher(List<BaseHandler> handlers) {
        this.handlers = handlers;
    }

    public BaseHandler match(String input) {
        for (BaseHandler handler : handlers) {
            if (handler.canHandle(input)) {
                return handler;
            }
        }
        return new FallbackHandler();
    }

}
