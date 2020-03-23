package ru.job4j.ood;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Interface created for tests
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public interface Cinema {
    /**
     * Method should has a realize about find Cinema session by predicate filter
     *
     * @param filter - filter
     * @return - cinema sessions
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Method should has a realize about buying tickets of cinema
     *
     * @param account - account
     * @param row     - row
     * @param column  - column
     * @param date    - date
     * @return - ticket
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Method should has a realize add a new sessions in List
     *
     * @param session - session
     */
    void add(Session session);
}
