package ru.job4j.ood.isp.menu;

import java.util.List;

/**
 * Class is an Item
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public class Item implements Somebody {

    /**
     * Name
     */
    private final String name;

    /**
     * Prefix
     */
    private final String prefix;

    /**
     * Children
     */
    private final List<Somebody> children;

    public Item(String name, String prefix, List<Somebody> children) {
        this.name = name;
        this.prefix = prefix;
        this.children = children;
    }

    /**
     * Method do anything
     */
    @Override
    public void doSomething() {
        //TODO something
    }

    public List<Somebody> getChildren() {
        return children;
    }


    public String getName() {
        return name;
    }


    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return prefix + "." + name;
    }
}
