package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Simple Tree structure of data
 *
 * @author Денис Висков
 * @version 1.0
 * @since 20.02.2020
 */
public interface SimpleTree<E> {

    /**
     * Method should add new element by given parameters
     *
     * @param parent - parent
     * @param child  - child
     * @return - true or false in dependency of result
     */
    boolean add(E parent, E child);

    /**
     * This method should looking for Node<E> by given value in parameters
     *
     * @param value - value
     * @return - Optional Node<E>
     */
    Optional<Node<E>> findBy(E value);

    /**
     * Class has a model of data Node<E>
     *
     * @param <E> - generic parameter
     */
    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
