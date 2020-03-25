package list;

/**
 * CLass has realize queue on base of stack
 *
 * @author Денис Висков
 * @version 1.0
 * @since 10.02.2020
 */
public class SimpleQueue<T> {
    /**
     * First
     */
    private SimpleStack<T> first = new SimpleStack<>();

    /**
     * Second
     */
    private SimpleStack<T> second = new SimpleStack<>();

    /**
     * Size first
     */
    private int sizeFirst = 0;

    /**
     * Size second
     */
    private int sizeSecond = 0;

    /**
     * Method returns T element and remove his of queue
     *
     * @return - T
     */
    public T poll() {
        pushAllElement();
        return second.poll();
    }

    /**
     * Method has an add of gave element in queue
     *
     * @param value - T value
     */
    public void push(T value) {
        first.push(value);
        this.sizeFirst++;
    }

    /**
     * Method has realize pushing all element which includes
     * in first simpleStack to second SimpleStack
     */
    private void pushAllElement() {
        while (this.sizeSecond < this.sizeFirst) {
            second.push(first.poll());
            this.sizeSecond++;
        }
    }
}
