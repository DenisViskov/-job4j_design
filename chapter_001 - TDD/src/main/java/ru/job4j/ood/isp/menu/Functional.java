package ru.job4j.ood.isp.menu;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 07.06.2020
 */
public interface Functional<Structure> {

    void printStructure();

    void select(String name);
}
