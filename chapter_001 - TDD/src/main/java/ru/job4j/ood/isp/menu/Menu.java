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

    private final Set<Something> tree;

    public Menu(Something... items) {
        this.tree = new TreeSet<>(Arrays.asList(items));
    }

    @Override
    public Something getItem(String name) {
        return tree.stream()
                .filter(item -> item.getname().equals(name))
                .findFirst().get();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        tree.forEach(item -> {
            int length = item.getPrefix().length();
            int count = 1;
            while (count <= length && length > 2) {
                builder.append("-");
                count++;
            }
            builder.append(item.toString());
            builder.append(System.lineSeparator());
        });
        return builder.toString();
    }
}
