package softreference;

/**
 * Interface of Cache
 *
 * @author Денис Висков
 * @version 1.0
 * @since 09.07.2020
 */
public interface Cache {

    /**
     * Method should return content from store by given name
     *
     * @param name
     * @param store
     * @return content
     */
    String getContent(String name, Store store);
}
