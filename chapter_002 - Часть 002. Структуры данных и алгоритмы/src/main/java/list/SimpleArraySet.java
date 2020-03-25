package list;

import java.util.Iterator;

/**
 * Class has realize simple set on base simple array
 *
 * @author Денис Висков
 * @version 1.0
 * @since 13.02.2020
 */
public class SimpleArraySet<E> implements Iterable<E> {
    /**
     * Simple array
     */
    private DynamicsContainer<E> simpleArray = new DynamicsContainer<>();

    /**
     * Method has realize add element in Set without use duplicates
     *
     * @param value - value
     */
    public void add(E value) {
        if (!hasElement(value)) {
            simpleArray.add(value);
        }
    }

    /**
     * Method has a check value in Set
     *
     * @param value
     * @return - true or false in dependency of result
     */
    private boolean hasElement(E value) {
        boolean result = false;
        for (E element : simpleArray) {
            if (element != null && element.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}
