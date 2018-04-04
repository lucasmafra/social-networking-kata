package com.lucasmafra.socialnetworking.infrastructure;

import com.lucasmafra.socialnetworking.infrastructure.Clock;

import java.util.Date;

public class ClockImpl implements Clock {
    public Date now() {
        return new Date();
    }
}
