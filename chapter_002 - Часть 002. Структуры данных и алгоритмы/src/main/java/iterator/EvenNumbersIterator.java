package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class has realize iterator for even numbers
 *
 * @author Денис Висков
 * @version 1.0
 * @since 31.01.2020
 */
public class EvenNumbersIterator implements Iterable {
    /**
     * Numbers
     */
    private int[] numbers;

    /**
     * Index
     */
    private int index = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (index < numbers.length) {
                    if (isEven(numbers[index])) {
                        result = true;
                        break;
                    }
                    index++;
                }
                return result;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return numbers[index++];
                }
                throw new NoSuchElementException();
            }

            /**
             * Method is checking of even numbers
             *
             * @param number - number
             * @return - true or false
             */
            private boolean isEven(int number) {
                return number % 2 == 0;
            }
        };
    }
}
