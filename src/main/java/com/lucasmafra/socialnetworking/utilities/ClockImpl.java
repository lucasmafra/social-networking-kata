package com.lucasmafra.socialnetworking.utilities;

import java.util.Date;

public class ClockImpl implements Clock {
    public Date now() {
        return new Date();
    }
}
