package map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    @Test
    public void insertTest() {
        HashMap<String, String> map = new HashMap<>();
        boolean out = map.insert("12", "Privet");
        assertThat(out, is(true));
    }

    @Test
    public void whenWeHaveBehindTheSideOfEndInsertTest() {
        HashMap<String, String> map = new HashMap<>();
        boolean out;
        map.insert("12", "Privet");
        map.insert("vasa", "Privet");
        map.insert("petya", "Privet");
        map.insert("Fedor", "Privet");
        map.insert("mem", "Privet");
        map.insert("123", "Privet");
        map.insert("Jora", "Privet");
        map.insert("asfg", "Privet");
        map.insert("zxcv", "Privet");
        map.insert("1asdfg2", "Privet");
        map.insert("1gaf2", "Privet");
        map.insert("asd", "Privet");
        map.insert("asfg2", "Privet");
        map.insert("asfg", "Privet");
        map.insert("zxcv", "Privet");
        map.insert("1asdfg2", "Privet");
        map.insert("1gaf2", "Privet");
        map.insert("asd", "Privet");
        map.insert("ass", "Privet");
        map.insert("gff", "Privet");
        map.insert("1sdfas2", "Privet");
        out = map.insert("2", "Privet");
        assertThat(out, is(true));
    }

    @Test
    public void getTest() {
        HashMap<Integer, String> map = new HashMap<>();
        boolean whenNot = false;
        map.insert(1, "Privet");
        map.insert(2, "Poka");
        map.insert(3, "Good");
        map.insert(4, "ZZZ");
        assertThat(map.get(3), is("Good"));
        assertThat(map.get(4), is("ZZZ"));
        assertThat(map.get(1), is("Privet"));
        try {
            map.get(5);
        } catch (NoSuchElementException e) {
            whenNot = true;
        } finally {
            assertThat(whenNot, is(true));
        }
    }

    @Test
    public void deleteTest() {
        HashMap<Integer, String> map = new HashMap<>();
        boolean result = false;
        map.insert(1, "Privet");
        map.insert(2, "Poka");
        map.insert(3, "Good");
        map.insert(4, "ZZZ");
        map.delete(1);
        map.delete(2);
        try {
            map.get(1);
        } catch (NoSuchElementException e) {
            result = true;
        } finally {
            assertThat(result, is(true));
            result = false;
        }
        try {
            map.get(2);
        } catch (NoSuchElementException e) {
            result = true;
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void iteratorTest() {
        HashMap<Integer, String> map = new HashMap<>();
        Iterator iterator = map.iterator();
        map.insert(1, "Privet");
        map.insert(2, "Poka");
        map.insert(3, "Good");
        map.insert(4, "ZZZ");
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(map.get(1)));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(map.get(2)));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(map.get(3)));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(map.get(4)));
        assertThat(iterator.hasNext(), is(false));
    }
}