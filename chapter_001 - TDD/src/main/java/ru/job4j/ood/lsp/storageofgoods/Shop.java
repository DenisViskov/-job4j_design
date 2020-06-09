package ru.job4j.ood.lsp.storageofgoods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class Shop implements Storage<Food> {

    /**
     * List of goods
     */
    private List<Food> listOfGoods = new ArrayList<>();

    /**
     * Method add good in list of goods
     *
     * @param good - good
     */
    @Override
    public void add(Food good) {
        if (!listOfGoods.contains(good)) {
            listOfGoods.add(good);
        }
    }

    @Override
    public List<Food> getAll() {
        return listOfGoods;
    }
}
