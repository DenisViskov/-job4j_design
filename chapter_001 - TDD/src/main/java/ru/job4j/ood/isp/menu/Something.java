package ru.job4j.ood.isp.menu;

/**
 * Interface of somebody
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

    String getname();

    String getPrefix();
}
