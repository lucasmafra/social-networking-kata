package com.lucasmafra.socialnetworking.infrastructure.console.main;

import com.lucasmafra.socialnetworking.infrastructure.console.handlers.BaseHandler;
import com.lucasmafra.socialnetworking.infrastructure.console.handlers.HandlerMatcher;
import com.lucasmafra.socialnetworking.infrastructure.console.handlers.HandlersFactory;

import java.io.IOException;
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
        List<BaseHandler> handlers = new HandlersFactory(context).createHandlers();
        return new HandlerMatcher(handlers);
    }

}
