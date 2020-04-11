package ru.job4j.generic;

/**
 * Class has realize interface store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 06.02.2020
 */
public class AbstractStore implements Store {
    /**
     * Base
     */
    SimpleArray<Base> container;

    public AbstractStore(SimpleArray container) {
        this.container = container;
    }

    /**
     * Method has realize add in base new model
     *
     * @param model - model
     */
    @Override
    public void add(Base model) {
        this.container.add(model);
    }

    /**
     * Method has realize replace of element in base on the gave ID
     *
     * @param id    - id of element
     * @param model - model
     * @return - true or false
     */
    @Override
    public boolean replace(String id, Base model) {
        Base element = findById(id);
        int index = element != null ? this.container.findIndexOnObject(element) : -1;
        if (index != -1) {
            this.container.set(index, model);
            return true;
        }
        return false;
    }

    /**
     * Method has realize delete of element in base on the gave ID
     *
     * @param id - id
     * @return - true or false
     */
    @Override
    public boolean delete(String id) {
        Base element = findById(id);
        int index = element != null ? this.container.findIndexOnObject(element) : -1;
        if (index != -1) {
            this.container.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Method has realize looking for element in base on the gave ID
     *
     * @param id - id
     * @return - found element or null
     */
    @Override
    public Base findById(String id) {
        Base result = null;
        for (Base element : this.container) {
            if (element.getId().equals(id)) {
                result = element;
                return result;
            }
        }
        return result;
    }
}
