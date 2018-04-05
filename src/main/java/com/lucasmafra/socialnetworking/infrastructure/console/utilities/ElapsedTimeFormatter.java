package com.lucasmafra.socialnetworking.infrastructure.console.utilities;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ElapsedTimeFormatter {

    public String format(Date from, Date to) {
        Instant initialTimestamp = from.toInstant();
        Instant endTimestamp = to.toInstant();
        Duration duration = Duration.between(initialTimestamp, endTimestamp);
        Long seconds = duration.getSeconds();
        if (seconds != 1) {
            return seconds + " seconds ago";
        } else {
            return seconds + " second ago";
        }
    }

}
