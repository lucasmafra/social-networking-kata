package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

public interface Handler {
    boolean canHandle(String input);
    void handle(String input);
}

