package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class has realizes reading file of log and filter him by 404 error
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.03.2020
 */
public class LogFilter {

    /**
     * Method has realizes reading of file log and filter him by 404 error
     *
     * @param file - path
     * @return - list of 404 errors
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                reader.lines()
                        .filter(line -> line.contains("404"))
                        .forEach(line -> {
                            if (check(line.split(" "))) {
                                result.add(line);
                            }
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method is an additionally check on the exist 404 error
     *
     * @param split - split of array
     * @return - true or false in dependency of result operations
     */
    private static boolean check(String[] split) {
        return split[split.length - 2].equals("404") ? true : false;
    }

    /**
     * Method has realizes writing into the file log which we've got from first file of log
     *
     * @param log  - log
     * @param file - destination path
     */
    public void save(List<String> log, String file) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            log.forEach(writer::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
