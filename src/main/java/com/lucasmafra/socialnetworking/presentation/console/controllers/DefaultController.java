package com.lucasmafra.socialnetworking.presentation.console.controllers;

public class DefaultController implements Controller {

    @Override
    public boolean canHandle(String input) {
        return true;
    }

    @Override
    public void handle(String input) {
        return;
    }
}
