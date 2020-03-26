package ru.job4j.ood.tdd;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

@Ignore
public class CinemaTest {

    @Ignore
    public void findTest() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    public void buyTest() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    public void whenTryToSelectPlaceWhichClosed() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 2, date);
        Ticket result = null;
        assertThat(ticket, is(result));
    }

    @Ignore
    public void whenTryToSelectDateWhichNotEnabled() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 35, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 2, date);
        Ticket result = null;
        assertThat(ticket, is(result));
    }

    @Ignore
    public void whenSelectedCinemaWhichDontHave() {
        Cinema cinema = new Cinema5D();
        List<Session> sessions = cinema.find(session -> true);
        Assert.assertThat(sessions.size(), is(0));
    }

}