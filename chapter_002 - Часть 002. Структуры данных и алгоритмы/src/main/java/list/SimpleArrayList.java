package list;

/**
 * Class has realize simple linkedList
 *
 * @author Денис Висков
 * @version 1.0
 * @since 07.02.2020
 */
public class SimpleArrayList<E> {
    /**
     * Size
     */
    private int size;

    /**
     * First element
     */
    private Node<E> first;

    /**
     * Method has realize add data to list
     *
     * @param data - data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method has realize delete of first element in list
     *
     * @return - E
     */
    public E delete() {
        Node<E> willDeleted = this.first;
        this.first = willDeleted.next;
        this.size--;
        return willDeleted.data;
    }

    /**
     * Method has realize get of element on index
     *
     * @param index - index
     * @return - E
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Method returns size of list
     *
     * @return - size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Class has realizes holding of data
     *
     * @param <E>
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
