package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;

public class BaseAcceptanceTest {

    @Before
    public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    protected AppContextStub context;
    protected App app;

    protected void command(String command) {
        context.getBufferedReader().setNextLine(command);
        app.processInput();
    }

    protected void resetPrinter() {
        context.getPrintStream().resetPrinter();
    }

    protected String getPrintedContent() {
        return context.getPrintStream().getPrintedContent();
    }

}
