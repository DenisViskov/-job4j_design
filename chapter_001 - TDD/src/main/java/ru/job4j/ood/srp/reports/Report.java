package ru.job4j.ood.srp.reports;

import java.util.function.Predicate;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 30.05.2020
 */
public interface Report<Data> {

    /**
     * Method should generate report for anybody
     *
     * @param filter - filter
     * @return - some data
     */
    Data generate(Predicate<Employer> filter);
}
