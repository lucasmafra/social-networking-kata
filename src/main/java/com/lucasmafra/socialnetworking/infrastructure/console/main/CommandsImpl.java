package com.lucasmafra.socialnetworking.infrastructure.console.main;

import java.util.regex.Pattern;

public class CommandsImpl implements Commands {

    @Override
    public Pattern getPostCommandPattern() {
        String USER = "^(\\w+)";
        String ACTION = " -> ";
        String MESSAGE = "(.*)$";
        return Pattern.compile(USER + ACTION + MESSAGE);
    }

    @Override
    public Pattern getFollowCommandPattern() {
        String FOLLOWER = "^(\\w+)";
        String ACTION = " follows ";
        String FOLLOWED = "(\\w+)";
        return Pattern.compile(FOLLOWER + ACTION + FOLLOWED);
    }

    @Override
    public Pattern getReadTimelineCommandPattern() {
        String USER = "^(\\w+)";
        return Pattern.compile(USER);
    }

    @Override
    public Pattern getReadWallCommandPattern() {
        String USER = "^(\\w+)";
        String ACTION = " wall$";
        return Pattern.compile(USER + ACTION);
    }
}
