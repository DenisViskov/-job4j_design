package ru.job4j.ood.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DisplayTest {

    @Test
    public void showPolygonTest() {
        Display display = new Display(new Place());
        display.showPolygon();
    }
}