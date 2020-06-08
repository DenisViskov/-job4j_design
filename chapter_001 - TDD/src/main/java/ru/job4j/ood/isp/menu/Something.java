package ru.job4j.ood.isp.menu;

/**
 * Interface of something
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public interface Something extends Comparable<Something> {

    /**
     * Method should do something
     */
    void doSomething();

    /**
     * Method should return name
     *
     * @return name
     */
    String getName();

    /**
     * Method should return prefix
     *
     * @return prefix
     */
    String getPrefix();
}
