package ru.job4j.generic;

/**
 * Class has realize interface of Store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 06.02.2020
 */
public class RoleStore<Role> extends AbstractStore {

    public RoleStore(SimpleArray<Role> container) {
        super(container);
    }
}
