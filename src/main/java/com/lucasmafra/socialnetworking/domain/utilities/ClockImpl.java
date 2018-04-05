package com.lucasmafra.socialnetworking.domain.utilities;

import java.util.Date;

public class ClockImpl implements Clock {
    public Date now() {
        return new Date();
    }
}
