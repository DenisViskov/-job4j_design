package ru.job4j.ood.isp.menu;

import java.util.List;

/**
 * Interface of somebody
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public interface Something {

    /**
     * Method should do something
     */
    void doSomething();

    /**
     * Method should return children
     *
     * @return - children
     */
    List<Something> getChildren();

    String getName();
}
