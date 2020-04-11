package list;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicsContainerTest {
    DynamicsContainer<Integer> container;

    @Before
    public void setUp() {
        container = new DynamicsContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
    }

    @Test
    public void add() {
        container.add(10);
        Assert.assertThat(container.get(9), Is.is(10));
        container.add(11);
        Assert.assertThat(container.get(10), Is.is(11));
    }

    @Test
    public void get() {
        Assert.assertThat(container.get(0), Is.is(1));
        Assert.assertThat(container.get(4), Is.is(5));
        Assert.assertThat(container.get(7), Is.is(8));
    }

    @Test
    public void iterator() {
        Iterator<Integer> it = container.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(1));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(2));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(4));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(5));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(6));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(7));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(8));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(9));
        Assert.assertThat(it.hasNext(), Is.is(true));
        it.next();
        Assert.assertThat(it.hasNext(), Is.is(false));
    }

    @Test
    public void whenIteratorThrowExeption() {
        Iterator<Integer> it = container.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        container.add(10);
        container.add(11);
        boolean flag = false;
        try {
            it.hasNext();
        } catch (ConcurrentModificationException e) {
            flag = true;
        } finally {
            Assert.assertThat(flag, Is.is(true));
        }
    }
}