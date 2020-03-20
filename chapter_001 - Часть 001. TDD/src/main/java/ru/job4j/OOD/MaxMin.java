package ru.job4j.OOD;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Set<T> max = new TreeSet<>(comparator);
        max.addAll(value);
        return (T) max.toArray()[max.toArray().length - 1];
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
        Set<T> min = new TreeSet<>(comparator);
        min.addAll(value);
        return (T) min.toArray()[0];
    }
}
