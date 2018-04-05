package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;
import com.lucasmafra.socialnetworking.infrastructure.data.InMemoryPostGateway;

public class AppContextStub extends AppContext {

    private BufferedReaderStub bufferedReader = new BufferedReaderStub();
    private PrintStreamStub printStream = new PrintStreamStub();
    private ClockStub clock = new ClockStub();
    private PostGateway postGateway = new InMemoryPostGateway(clock);

    @Override
    public BufferedReaderStub getBufferedReader() {
        return bufferedReader;
    }

    @Override
    public PrintStreamStub getPrintStream() {
        return printStream;
    }

    @Override
    public ClockStub getClock() { return clock; }

    @Override
    public PostGateway getPostGateway() {
        return postGateway;
    }
}
