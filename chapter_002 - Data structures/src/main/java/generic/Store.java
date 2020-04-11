package ru.job4j.generic;

/**
 * Interface  containers store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 06.02.2020
 */
public interface Store<T extends Base> {
    /**
     * Method should add gave parameters
     *
     * @param model - model
     */
    void add(T model);

    /**
     * Method should replace model in base on the gave parametres
     *
     * @param id    - id of element
     * @param model - model
     * @return - true or false in dependency of result
     */
    boolean replace(String id, T model);

    /**
     * Method should delete element on the gave ID
     *
     * @param id - id
     * @return - true or false in dependency of result
     */
    boolean delete(String id);

    /**
     * Method should looking for element on the gave id
     *
     * @param id - id
     * @return - element
     */
    T findById(String id);
}
