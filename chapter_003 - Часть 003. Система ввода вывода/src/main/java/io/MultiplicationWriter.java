package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class has realizes writing in file multiplication table
 *
 * @author Денис Висков
 * @version 1.0
 * @since 25.03.2020
 */
public class MultiplicationWriter {
    /**
     * Table
     */
    private MatrixTable table;

    public MultiplicationWriter(MatrixTable table) {
        this.table = table;
    }

    /**
     * Method has realizes writing in file multiplication table
     *
     * @param size - size
     * @param path - path
     * @throws IOException
     */
    public void tableWriter(int size, String path) throws IOException {
        int[][] result = table.multiple(size);
        FileOutputStream writer = new FileOutputStream(path);
        for (int[] array : result) {
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]).getBytes());
                writer.write(" ".getBytes());
            }
            writer.write(System.lineSeparator().getBytes());
        }
        writer.close();
    }

}
