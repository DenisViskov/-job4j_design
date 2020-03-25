package list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {
    private Node first = new Node(1);
    private Node two = new Node(2);
    private Node third = new Node(3);
    private Node four = new Node(4);

    @Test
    public void hasCycleTest() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleInCentralTest() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(two);
        four.setNext(null);
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleReturnsFalseTest() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        assertThat(first.hasCycle(first), is(false));
    }
}