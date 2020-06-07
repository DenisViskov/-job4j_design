package ru.job4j.ood.isp.menu;

import java.util.*;

/**
 * Class is a menu
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public class Menu implements Structure<Something> {

    private List<Something> somethings;

    public Menu(List<Something> somethings) {
        this.somethings = somethings;
    }

    public Menu() {
        somethings = new ArrayList<>();
    }

    @Override
    public List<Something> addToMain(Something item) {
        somethings.add(item);
        return somethings;
    }

    @Override
    public List<Something> addIntoItem(Something add, Something to) {
        to.getChildren().add(add);
        return somethings;
    }

    @Override
    public List<Something> deleteItem(Something item) {
        return null;
    }

    @Override
    public Something getItem(String name) {
        return null;
    }

    @Override
    public List<Something> getAll() {
        return somethings;
    }
}
