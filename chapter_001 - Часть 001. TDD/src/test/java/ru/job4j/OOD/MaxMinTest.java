package ru.job4j.OOD;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int out = new MaxMin().max(List.of(1, 2, 3, 6, 7, 9), comparator);
        Assert.assertThat(out, Is.is(9));
    }

    @Test
    public void minTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int out = new MaxMin().min(List.of(1, 2, 3, 6, 7, 9), comparator);
        Assert.assertThat(out, Is.is(1));
    }
}