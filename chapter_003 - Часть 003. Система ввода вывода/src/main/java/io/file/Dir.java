package io.file;

import java.io.File;

/**
 * Class has realizes work with files directory
 *
 * @author Денис Висков
 * @version 1.0
 * @since 01.04.2020
 */
public class Dir {

    /**
     * Method has realizes print on console file name and size that file
     *
     * @param path - path file
     */
    public void printFileNameAndSize(File path) {
        validation(path);
        for (File subfile : path.listFiles()) {
            System.out.println(String.format("name : %s; size : %s", subfile.getName(), subfile.getTotalSpace()));
        }
    }

    /**
     * Method has realizes print on console list of files by given path in parameters
     *
     * @param path - File path
     */
    public void printDirectory(File path) {
        validation(path);
        System.out.println(String.format("size : %s", path.getTotalSpace()));
        for (File subfile : path.listFiles()) {
            System.out.println(subfile.getAbsoluteFile());
        }
    }

    /**
     * Method has realizes of validations by given file
     *
     * @param path - file
     * @throws IllegalStateException
     */
    private void validation(File path) {
        if (!path.exists()) {
            throw new IllegalStateException(String.format("Not exist %s", path.getAbsoluteFile()));
        }
        if (!path.isDirectory()) {
            throw new IllegalStateException(String.format("Not directory %s", path.getAbsoluteFile()));
        }
    }
}

