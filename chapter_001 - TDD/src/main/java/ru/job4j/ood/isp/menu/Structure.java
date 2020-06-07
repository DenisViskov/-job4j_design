package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface of structure
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.06.2020
 */
public interface Structure<Something> {

    List<Something> addToMain(Something item);

    List<Something> addIntoItem(Something add, Something to);

    List<Something> deleteItem(Something item);

    Something getItem(String name);

    List<Something> getAll();
}
