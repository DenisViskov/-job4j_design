package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AutomobileTest {

    @Test
    public void runTest() {
        assertThat(new Automobile("", 25, 2).run(),
                lessThan(61));
    }
}