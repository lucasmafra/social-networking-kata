package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.infrastructure.console.main.AppContext;

public class AppContextStub extends AppContext {

    private BufferedReaderStub bufferedReader = new BufferedReaderStub();
    private PrintStreamStub printStream = new PrintStreamStub();
    private ClockStub clock = new ClockStub();

    @Override
    public BufferedReaderStub getBufferedReader() {
        return bufferedReader;
    }

    @Override
    public PrintStreamStub getPrintStream() {
        return printStream;
    }

    @Override
    public ClockStub getClock() {
        return clock;
    }

}
