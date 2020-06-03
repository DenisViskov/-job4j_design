package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.function.Predicate;

/**
 * Class is a menu
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public class Menu implements Structure<Somebody> {

    /**
     * Tree
     */
    private List<Somebody> tree;

    public Menu(List<Somebody> tree) {
        this.tree = tree;
    }

    public Menu() {
    }

    @Override
    public void printMenu() {

    }

    @Override
    public Somebody select(String name) {
        return null;
    }

    @Override
    public void collectStructure(List<Somebody> items) {

    }


}
