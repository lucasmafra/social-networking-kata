package com.lucasmafra.socialnetworking.infrastructure.console.handlers;

import java.util.regex.Pattern;

public class FallbackHandler extends BaseHandler {

    @Override
    public boolean canHandle(String input) {
        return true;
    }

    @Override
    public void handle(String input) {
        return;
    }

    @Override
    Pattern getInputPattern() {
        return null;
    }
}
