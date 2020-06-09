package ru.job4j.ood.lsp.storageofgoods;

import java.util.List;

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

    /**
     * Method should do resort foods from given storage
     *
     * @param storage
     * @return list
     */
    List<Storage> resort(List<Storage> storage);
}
