package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

public class DefaultHandler implements Handler {

    @Override
    public boolean canHandle(String input) {
        return false;
    }

    @Override
    public void handle(String input) {
        return;
    }
}
