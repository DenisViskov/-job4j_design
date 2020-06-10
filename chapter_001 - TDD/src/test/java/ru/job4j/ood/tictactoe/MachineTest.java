package ru.job4j.ood.tictactoe;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MachineTest {

    @Test
    public void doStepTest() throws IOException {
        Machine machine = new Machine(Figure.O, new Place());
        boolean result = machine.doStep();
        assertThat(result, is(true));
    }
}