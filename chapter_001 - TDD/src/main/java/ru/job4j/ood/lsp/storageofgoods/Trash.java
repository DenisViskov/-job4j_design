package ru.job4j.ood.lsp.storageofgoods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class Trash implements Storage<Food> {

    /**
     * Trash
     */
    private List<Food> trash = new ArrayList<>();

    /**
     * Method adds good in trash
     *
     * @param good - good
     */
    @Override
    public void add(Food good) {
        trash.add(good);
    }

    public List<Food> getTrash() {
        return trash;
    }
}
