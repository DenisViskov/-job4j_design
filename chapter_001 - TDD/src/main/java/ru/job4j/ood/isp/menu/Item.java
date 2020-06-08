package ru.job4j.ood.isp.menu;

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

    public Item(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    /**
     * Method do something
     */
    @Override
    public void doSomething() {
        //TODO something
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return getPrefix() + "." + getName();
    }

    @Override
    public int compareTo(Something o) {
        return this.prefix.compareTo(o.getPrefix());
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
                && Objects.equals(prefix, item.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prefix);
    }
}
