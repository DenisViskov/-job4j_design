package softreference;

/**
 * Abstract storage
 *
 * @author Денис Висков
 * @version 1.0
 * @since 09.07.2020
 */
public interface Store<Item> {

    /**
     * Method should return something item from storage by given name
     *
     * @param name
     * @return item
     */
    Item get(String name);
}
