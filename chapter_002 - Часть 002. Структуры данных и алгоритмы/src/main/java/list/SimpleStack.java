package list;

/**
 * Class has realize a simple stack
 *
 * @author Денис Висков
 * @version 1.0
 * @since 10.02.2020
 */
public class SimpleStack<T> {
    /**
     * Container
     */
    private SimpleArrayList<T> container = new SimpleArrayList<>();

    /**
     * Method returns T element and remove his of stack
     *
     * @return - T
     */
    public T poll() {
        return container.delete();
    }

    /**
     * Method has an add of gave element in stack
     *
     * @param value - T value
     */
    public void push(T value) {
        container.add(value);
    }
}
