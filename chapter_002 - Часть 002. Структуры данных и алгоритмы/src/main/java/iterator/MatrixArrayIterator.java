package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class has realizes functional of Double Array iterator
 *
 * @author Денис Висков
 * @version 1.0
 * @since 29.01.2020
 */
public class MatrixArrayIterator implements Iterator {
    /**
     * values
     */
    private int[][] values;

    /**
     * First index
     */
    private int indexFirst = 0;

    /**
     * Second index
     */
    private int indexSecond = 0;

    public MatrixArrayIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return indexFirst < values.length || indexSecondLessThanLength() ? true : false;
    }

    @Override
    public Object next() {
        while (values[indexFirst].length == 0) {
            indexFirst++;
        }
        int result = values[indexFirst][indexSecond++];
        if (indexSecond == values[indexFirst].length) {
            indexSecond = 0;
            indexFirst++;
        }
        return result;
    }

    /**
     * Method has realize checking of indexSecond less than that lenght
     *
     * @return - true or false
     */
    private boolean indexSecondLessThanLength() {
        if (indexFirst < values.length) {
            return indexSecond < values[indexFirst].length
                    && values[indexFirst].length != 1;
        } else {
            return false;
        }
    }
}
