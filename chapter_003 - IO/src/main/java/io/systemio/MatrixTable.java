package io.systemio;

/**
 * Class has realizes multiplication table
 *
 * @author Денис Висков
 * @version 1.0
 * @since 25.03.2020
 */
public class MatrixTable {

    /**
     * Method has realizes multiplication table by given size in parameters
     *
     * @param size - size
     * @return - array of multiplication table
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        int outterCount = 1;
        int innerCount = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = innerCount * outterCount;
                innerCount++;
            }
            innerCount = 1;
            outterCount++;
        }
        return table;
    }
}
