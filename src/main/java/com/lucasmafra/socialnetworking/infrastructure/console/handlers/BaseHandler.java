package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import java.util.regex.Pattern;

public abstract class BaseHandler {

    public abstract void handle(String input);

    abstract Pattern getInputPattern();

    boolean canHandle(String input) {
            Pattern pattern = getInputPattern();
            return pattern.matcher(input).matches();
    }
}

