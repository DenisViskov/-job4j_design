package io;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Class has realizes looking for arguments from main parameters
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.03.2020
 */
public class ArgZip {
    /**
     * Arguments
     */
    private final String[] arguments;

    public ArgZip(String[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Method returns directory folder
     *
     * @return - directory
     */
    public String directory() {
        return search("-d");
    }

    /**
     * Method returns exclude of file extensions
     *
     * @return - exclude extension
     */
    public String exclude() {
        return search("-e");
    }

    /**
     * Method returns destination path
     *
     * @return - destination path
     */
    public String output() {
        return search("-o");
    }

    /**
     * Method has realizes looking for argument by given key in parameters
     *
     * @param key - key
     * @return - argument
     */
    private String search(String key) {
        String result = "";
        if (!Arrays.stream(arguments)
                .anyMatch(keys -> keys.equals(key))) {
            throw new NoSuchElementException("Doesn't have contain element");
        }
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].equals(key)) {
                result = arguments[i + 1];
            }
        }
        return result;
    }
}
