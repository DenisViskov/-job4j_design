package ru.job4j.generic;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class SimpleArrayTest {
    private SimpleArray<String> strings = new SimpleArray<>(6);

    @Before
    public void setUp() {
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
    }

    @Test
    public void add() {
        strings.add("1");
        Assert.assertEquals("1", strings.get(5));
    }

    @Test
    public void set() {
        strings.set(0, "2");
        Assert.assertEquals("2", strings.get(0));
    }

    @Test
    public void remove() {
        strings.add("1");
        strings.remove(0);
        Assert.assertThat(List.of("2", "3", "4", "5", "1").toArray(), Is.is(strings.getArray()));
        strings.remove(1);
        Assert.assertThat(List.of("2", "4", "5", "1").toArray(), Is.is(strings.getArray()));
        strings.remove(2);
        Assert.assertThat(List.of("2", "4", "1").toArray(), Is.is(strings.getArray()));
        strings.remove(1);
        Assert.assertThat(List.of("2", "1").toArray(), Is.is(strings.getArray()));
    }

    @Test
    public void get() {
        Assert.assertThat(strings.get(2), Is.is("3"));
    }

    @Test
    public void iteratorNext() {
        Iterator<String> it = strings.iterator();
        Assert.assertThat(it.next(), Is.is("1"));
        Assert.assertThat(it.next(), Is.is("2"));
        Assert.assertThat(it.next(), Is.is("3"));
        Assert.assertThat(it.next(), Is.is("4"));
        Assert.assertThat(it.next(), Is.is("5"));
    }

    @Test
    public void iteratorHasNext() {
        Iterator<String> it = strings.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is("1"));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is("2"));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is("3"));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is("4"));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is("5"));
        Assert.assertThat(it.hasNext(), Is.is(false));
    }
}