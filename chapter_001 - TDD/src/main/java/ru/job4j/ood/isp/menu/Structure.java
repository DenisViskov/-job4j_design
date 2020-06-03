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
     * Method should print whole menu
     */
    void printMenu();

    /**
     * Method should select
     *
     * @param name
     * @return Something
     */
    Something select(String name);

    /**
     * Method should collects new Structure
     *
     * @param items
     */
    void collectStructure(List<Something> items);
}
