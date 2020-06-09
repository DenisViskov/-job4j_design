package ru.job4j.ood.lsp.storageofgoods;

import java.util.List;

/**
 * Interface of storage
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public interface Storage<Food> {

    /**
     * Method should adds goods
     *
     * @param good - good
     */
    void add(Food good);

    /**
     * Method should return all products
     *
     * @return list
     */
    List<Food> getAll();
}
