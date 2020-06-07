package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class is an Item
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public class Item implements Something {

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
    private List<Something> children;

    public Item(String name, String prefix, List<Something> children) {
        this.name = name;
        this.prefix = prefix;
        this.children = children == null ? new ArrayList<>() : children;
    }

    /**
     * Method do anything
     */
    @Override
    public void doSomething() {
        //TODO something
    }

    @Override
    public List<Something> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }


    public String getPrefix() {
        return prefix;
    }


    public void setChildren(List<Something> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return prefix + "." + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name)
                && Objects.equals(prefix, item.prefix)
                && Objects.equals(children, item.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prefix, children);
    }
}
