package ru.job4j.ood.lsp.storageofgoods;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is a warehouse
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class Warehouse implements Storage<Food> {

    /**
     * Foods
     */
    private List<Food> foods = new ArrayList<>();

    /**
     * Method adds good if that good is not exists
     *
     * @param good - good
     */
    @Override
    public void add(Food good) {
        if (!foods.contains(good)) {
            foods.add(good);
        }
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}
