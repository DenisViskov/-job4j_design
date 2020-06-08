package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface of structure
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public interface Structure<Something> {

    /**
     * Method should return something by given name
     *
     * @param name
     * @return something
     */
    Something getItem(String name);

    /**
     * Method should override toString
     *
     * @return string
     */
    String toString();
}
