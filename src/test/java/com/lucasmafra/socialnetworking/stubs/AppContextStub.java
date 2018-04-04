package com.lucasmafra.socialnetworking.stubs;

import com.lucasmafra.socialnetworking.presentation.console.AppContext;
import com.lucasmafra.socialnetworking.presentation.console.StorageContext;
import com.lucasmafra.socialnetworking.presentation.console.StorageContextImpl;
import com.lucasmafra.socialnetworking.utilities.*;

public class AppContextStub extends AppContext {

    private static final BufferedReaderStub bufferedReader = new BufferedReaderStub();
    private static final PrintStreamStub printStream = new PrintStreamStub();
    private static final ClockStub clock = new ClockStub();
    private static final StorageContext storageContext = new StorageContextImpl(clock);
    private static AppContextStub context;

    public static AppContextStub getInstance() {
        if (context == null) {
            context = new AppContextStub();
        }
        return context;
    }

    @Override
    public BufferedReaderStub getBufferedReader() {
        return bufferedReader;
    }

    @Override
    public PrintStreamStub getPrintStream() {
        return printStream;
    }

    @Override
    public StorageContext getStorageContext() {

        return storageContext;
    }

    public ClockStub getClock() {
        return clock;
    }

}
