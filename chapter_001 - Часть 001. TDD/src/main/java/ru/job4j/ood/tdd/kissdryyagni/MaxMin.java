package ru.job4j.ood.tdd.kissdryyagni;

import java.util.*;

/**
 * Class has realizes looking for max and min element
 *
 * @author Денис Висков
 * @version 1.0
 * @since 20.03.2020
 */
public class MaxMin {

    /**
     * Method has realizes looking for max element in List by given comparator in parameters
     *
     * @param value      - list
     * @param comparator - comparator
     * @param <T>        - any object
     * @return - max element
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return valueAnswer(value, comparator);
    }

    /**
     * Method has realizes looking for min element in List by given comparator in parameters
     *
     * @param value      - list
     * @param comparator - comparator
     * @param <T>        - any object
     * @return - min element
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return valueAnswer(value, comparator);
    }

    /**
     * Method has realizes looking for answer by given comparator in parameters
     *
     * @param value      - list of values
     * @param comparator - how to compare
     * @param <T>        - T
     * @return - value
     */
    private <T> T valueAnswer(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        int check = 1;
        while (check < value.size()) {
            result = comparator.compare(result, value.get(check)) > 0 ? result : value.get(check);
            check++;
        }
        return result;
    }
}
