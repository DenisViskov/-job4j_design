package ru.job4j.ood;

import java.util.Map;

/**
 * Interface for example of tests
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public interface Generator {

    /**
     * Method should return string includes template who's also includes key and value
     *
     * @param template - template
     * @param args     - map
     * @return - line
     */
    String produce(String template, Map<String, Object> args);
}
