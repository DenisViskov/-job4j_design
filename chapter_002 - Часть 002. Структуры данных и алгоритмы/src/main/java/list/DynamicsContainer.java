package list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class has realizes dynamics container with methods
 *
 * @author Денис Висков
 * @version 1.0
 * @since 07.02.2020
 */
public class DynamicsContainer<E> implements Iterable<E> {
    /**
     * Array of data
     */
    private Object[] container;

    /**
     * Index
     */
    private int index;

    /**
     * Count of changes
     */
    private int countOfChange;

    public DynamicsContainer() {
        this.container = new Object[10];
        this.index = 0;
        this.countOfChange = 0;
    }

    /**
     * Method has realize add of gave value in array of data
     *
     * @param value - value
     */
    public void add(E value) {
        if (index < this.container.length) {
            this.container[index++] = value;
        } else {
            this.container = Arrays.copyOf(this.container, this.container.length + 10);
            this.container[index++] = value;
            this.countOfChange++;
        }
    }

    /**
     * Method returns data on position
     *
     * @param position - position
     * @return - E
     */
    public E get(int position) {
        if (position > this.index || position < 0) {
            throw new IndexOutOfBoundsException("Index is located behind the side of date");
        }
        return (E) this.container[position];
    }

    @Override
    public Iterator<E> iterator() {
        countOfChange = 0;
        return new Iterator<E>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                if (countOfChange != 0) {
                    throw new ConcurrentModificationException("Structure of data base was been changed");
                }
                return count < container.length ? true : false;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[count++];
            }
        };
    }
}
