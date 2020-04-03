package io.fileinputstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class has realizes example how to work with try with resources
 *
 * @author Денис Висков
 * @version 1.0
 * @since 16.03.2020
 */
public class EvenNumberFile {

    /**
     * Method has realizes checking of number and print only even
     *
     * @param path - path
     * @throws IOException
     */
    public void isEvenNumber(String path) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.ready()) {
            reader.lines()
                    .forEach(line -> text.append(line + System.lineSeparator()));
        }
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line : lines) {
            int value = Integer.valueOf(line);
            boolean result = value % 2 == 0 ? true : false;
            System.out.println(value + ": " + result);
        }
    }
}
