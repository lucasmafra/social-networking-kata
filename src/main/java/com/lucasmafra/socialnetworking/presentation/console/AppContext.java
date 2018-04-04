package com.lucasmafra.socialnetworking.presentation.console;

import com.lucasmafra.socialnetworking.utilities.*;

public class AppContext {

    private static final BufferedReader bufferedReader = new BufferedReaderImpl();
    private static final PrintStream printStream = new PrintStreamImpl();
    private static final Clock clock = new ClockImpl();
    private static final StorageContext storageContext = new StorageContextImpl(clock);
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

    public StorageContext getStorageContext() {
        return storageContext;
    }
}
