package finallytask;

import java.util.Map;

/**
 * Interface is a validation
 *
 * @author Денис Висков
 * @version 1.0
 * @since 13.04.2020
 */
public interface Validate {

    /**
     * Method should do validation by given data from user
     *
     * @param line - entered user
     * @return - true or false in dependency of result
     */
    boolean validation(String line);

    /**
     * Method should return keys of user
     *
     * @return - keys
     */
    Map<String, String> keys();
}
