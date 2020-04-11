package ru.job4j.ood.tdd.kissdryyagni;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.ood.tdd.kissdryyagni.MaxMin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {

    @Test
    public void maxTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(6);
        input.add(7);
        input.add(9);
        int out = new MaxMin().max(input, comparator);
        Assert.assertThat(out, Is.is(9));
    }

    @Test
    public void minTest() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(6);
        input.add(7);
        input.add(9);
        int out = new MaxMin().min(input, comparator);
        Assert.assertThat(out, Is.is(1));
    }
}