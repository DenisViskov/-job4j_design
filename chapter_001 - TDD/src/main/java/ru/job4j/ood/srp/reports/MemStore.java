package ru.job4j.ood.srp.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class has realizes of interface Store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public class MemStore implements Store {
    /**
     * List of employers
     */
    private final List<Employer> employers = new ArrayList<>();

    /**
     * Method has realizes add new employer in list
     *
     * @param em - employer
     */
    public void add(Employer em) {
        employers.add(em);
    }

    /**
     * Method has override findBy from Store interface
     *
     * @param filter - filter
     * @return - employer
     */
    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
