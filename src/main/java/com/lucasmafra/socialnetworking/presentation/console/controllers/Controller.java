package com.lucasmafra.socialnetworking.presentation.console.controllers;

public interface Controller {

    boolean canHandle(String input);

    void handle(String input);
}
