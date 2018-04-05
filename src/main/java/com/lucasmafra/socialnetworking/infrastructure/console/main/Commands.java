package com.lucasmafra.socialnetworking.infrastructure.console.main;

import java.util.regex.Pattern;

public interface Commands {
    Pattern getPostCommandPattern();
    Pattern getFollowCommandPattern();
    Pattern getReadTimelineCommandPattern();
    Pattern getReadWallCommandPattern();

}
