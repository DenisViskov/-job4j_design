package ru.job4j.ood.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PersonTest {

    @Test
    public void doStepTest() throws IOException {
        Person person = new Person(Figure.X, new PlaceByThree());
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        boolean result = person.doStep();
        assertThat(result, is(true));
    }

    @Test
    public void doStepFalseTest() throws IOException {
        Person person = new Person(Figure.X, new PlaceByThree());
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        boolean result = person.doStep();
        assertThat(result, is(false));
    }

}