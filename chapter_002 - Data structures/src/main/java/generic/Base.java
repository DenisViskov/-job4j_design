package ru.job4j.generic;

/**
 * Class is an abstract  and realizes model of data base
 *
 * @author Денис Висков
 * @version 1.0
 * @since 06.02.2020
 */
public abstract class Base {
    /**
     * Id
     */
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
