package list;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicsLinkedContainerTest {

    @Test
    public void addTest() {
        DynamicsLinkedContainer<Integer> container = new DynamicsLinkedContainer<>();
        container.add(1);
        container.add(2);
        Assert.assertThat(container.get(0), Is.is(2));
    }

    @Test
    public void getTest() {
        DynamicsLinkedContainer<Integer> container = new DynamicsLinkedContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        Assert.assertThat(container.get(2), Is.is(1));
    }

    @Test
    public void iteratorTest() {
        DynamicsLinkedContainer<Integer> container = new DynamicsLinkedContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        Iterator<Integer> it = container.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(2));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(1));
        Assert.assertThat(it.hasNext(), Is.is(false));
    }

    @Test
    public void iteratorThrowExeptionTest() {
        DynamicsLinkedContainer<Integer> container = new DynamicsLinkedContainer<>();
        boolean flag = false;
        container.add(1);
        container.add(2);
        container.add(3);
        Iterator<Integer> it = container.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.hasNext(), Is.is(true));
        container.add(3);
        try {
            it.next();
        } catch (ConcurrentModificationException e) {
            flag = true;
        } finally {
            Assert.assertThat(flag, Is.is(true));
        }
    }
}