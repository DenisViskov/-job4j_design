package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TruckTest {

    @Test
    public void runTest() {
        assertThat(new Truck("", 25, 2).run(),
                lessThan(61));
    }
}