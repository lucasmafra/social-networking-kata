package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.lucasmafra.socialnetworking.doubles.ClockStub.asDate;

public class BaseAcceptanceTest {

    @Before public void
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

    protected void createPost(String userId, String message, int timeAgo, int unit) {
        context.getClock().setNow(getTimeAgo(timeAgo, unit));
        context.getPostGateway().savePost(userId, message);
    }

    private Date getTimeAgo(int amount, int unit) {
        Calendar date = Calendar.getInstance();
        date.add(unit, -amount);
        return date.getTime();
    }

    protected void updateClock() {
        context.getClock().setNow(new Date());
    }

    protected void createFollow(String follower, String followed) {
        context.getFollowGateway().saveFollow(follower, followed);
    }

    protected Date setClock(int year, int month, int day, int hour, int minute, int second) {
        Date date = asDate(year, month, day, hour, minute, second);
        context.getClock().setNow(date); // adjust clock
        return date;
    }

    protected List<Post> getPosts(String userId) {
        return context.getPostGateway().getPostsInReverseChronologicalOrder(userId);
    }

    protected List<String> getFollowingUsersFor(String userId) {
        return context.getFollowGateway().getFollowingUsersFor(userId);
    }
}
