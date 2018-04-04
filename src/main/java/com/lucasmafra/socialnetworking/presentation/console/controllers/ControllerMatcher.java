package com.lucasmafra.socialnetworking.presentation.console.controllers;

import com.lucasmafra.socialnetworking.presentation.console.controllers.Controller;
import com.lucasmafra.socialnetworking.presentation.console.controllers.DefaultController;

import java.util.List;

public class ControllerMatcher {

    private List<Controller> controllers;

    public ControllerMatcher(List<Controller> controllers) {
        this.controllers = controllers;
    }

    public Controller match(String input) {
        for (Controller controller: controllers) {
            if (controller.canHandle(input)) {
                return controller;
            }
        }
        return new DefaultController();
    }
}
