package ru.job4j.ood.tdd;

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
        Iterator<T> it = value.iterator();
        T result = it.next();
        while (it.hasNext()) {
            T element = it.next();
            result = comparator.compare(result, element) > 0 ? result : element;
        }
        return result;
    }
}
