package ru.job4j.ood.isp.menu;

/**
 * Interface of functional
 *
 * @author Денис Висков
 * @version 1.0
 * @since 07.06.2020
 */
public interface Functional<Structure> {

    /**
     * Method should print structure
     */
    void printStructure();

    /**
     * Method should select something and execute his function
     *
     * @param name
     */
    void select(String name);
}
