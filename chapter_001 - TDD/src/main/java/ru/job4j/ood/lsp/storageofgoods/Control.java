package ru.job4j.ood.lsp.storageofgoods;

/**
 * Interface of control quality
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public interface Control<Food, Storage> {

    /**
     * Method should do distributions goods by expire date
     *
     * @param good - good
     * @return - Storage
     */
    Storage executeDistribution(Food good);
}
