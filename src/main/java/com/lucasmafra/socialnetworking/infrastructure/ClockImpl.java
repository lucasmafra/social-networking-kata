package com.lucasmafra.socialnetworking.infrastructure;

import java.util.Date;

public class ClockImpl implements Clock {
    public Date now() {
        return new Date();
    }
}
