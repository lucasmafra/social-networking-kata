package com.lucasmafra.socialnetworking.infrastructure.console.main;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.infrastructure.Clock;
import com.lucasmafra.socialnetworking.infrastructure.ClockImpl;
import com.lucasmafra.socialnetworking.infrastructure.data.InMemoryPostGateway;
import com.lucasmafra.socialnetworking.infrastructure.console.utilities.*;

public class AppContext {

    private BufferedReader bufferedReader = new BufferedReaderImpl();
    private PrintStream printStream = new PrintStreamImpl();
    private Clock clock = new ClockImpl();
    private PostGateway postGateway = new InMemoryPostGateway(clock);
    private static AppContext context;

    public static AppContext getInstance() {
        if (context == null) {
            context = new AppContext();
        }
        return context;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public Clock getClock() {
        return clock;
    }

    public PostGateway getPostGateway() {
        return postGateway;
    }
}
