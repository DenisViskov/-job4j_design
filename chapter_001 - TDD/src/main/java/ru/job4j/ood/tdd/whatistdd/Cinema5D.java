package ru.job4j.ood.tdd.whatistdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class is an example for tests
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.03.2020
 */
public class Cinema5D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
