package com.lucasmafra.socialnetworking.infrastructure.console.main;

import com.lucasmafra.socialnetworking.domain.gateways.FollowGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.services.WallService;
import com.lucasmafra.socialnetworking.domain.Clock;
import com.lucasmafra.socialnetworking.domain.ClockImpl;
import com.lucasmafra.socialnetworking.infrastructure.data.InMemoryFollowGateway;
import com.lucasmafra.socialnetworking.infrastructure.data.InMemoryPostGateway;
import com.lucasmafra.socialnetworking.infrastructure.console.io.*;
import com.lucasmafra.socialnetworking.domain.services.WallServiceImpl;

public class AppContext {

    private BufferedReader bufferedReader = new BufferedReaderImpl();
    private PrintStream printStream = new PrintStreamImpl();
    private Clock clock = new ClockImpl();

    private InMemoryPostGateway postGateway = new InMemoryPostGateway(clock);
    private InMemoryFollowGateway followGateway = new InMemoryFollowGateway();

    private Commands commands = new CommandsImpl();

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

    public FollowGateway getFollowGateway() {
        return followGateway;
    }

    public Commands getCommands() {
        return commands;
    }
}
