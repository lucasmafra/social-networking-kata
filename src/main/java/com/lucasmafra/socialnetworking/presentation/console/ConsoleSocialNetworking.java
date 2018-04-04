package com.lucasmafra.socialnetworking.presentation.console;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.presentation.console.controllers.Controller;
import com.lucasmafra.socialnetworking.presentation.console.controllers.ControllerMatcher;
import com.lucasmafra.socialnetworking.presentation.console.controllers.PostingController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ConsoleSocialNetworking {

    private AppContext context;
    private ControllerMatcher controllerMatcher;
    private static String COMMAND_PREFIX = "> ";

    public static void main(String[] args) {
        ConsoleSocialNetworking app = new ConsoleSocialNetworking(AppContext.getInstance());
        app.start();
    }

    private void start() {
        while (true) {
            processInput();
        }
    }

    public ConsoleSocialNetworking(AppContext context) {
        this.context = context;
        controllerMatcher = createControllerMatcher();
    }

    public void processInput() {
        try {
            context.getPrintStream().print(COMMAND_PREFIX);
            String input = context.getBufferedReader().readNextLine();
            Controller controller = controllerMatcher.match(input);
            controller.handle(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ControllerMatcher createControllerMatcher() {
        List<Controller> controllers = createControllers();
        return new ControllerMatcher(controllers);
    }

    private List<Controller> createControllers() {
        List<Controller> controllers = new ArrayList<>();
        controllers.add(createPostingController());
        return controllers;
    }

    private Controller createPostingController() {
        PostGateway postGateway = context.getStorageContext().getPostGateway();
        return new PostingController(postGateway);
    }

}
