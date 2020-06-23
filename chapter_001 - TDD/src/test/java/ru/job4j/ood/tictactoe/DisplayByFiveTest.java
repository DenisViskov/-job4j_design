package ru.job4j.ood.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DisplayByFiveTest {

    private final PrintStream console = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteArray = new PrintStream(out);

    @Before
    public void setUp() throws Exception {
        System.setOut(byteArray);
    }

    @Test
    public void showPolygonTest() {
        PlaceByFive placeByFive = new PlaceByFive();
        Gamer first = new Person(Figure.X, placeByFive);
        Gamer second = new Machine(Figure.O, placeByFive);
        placeByFive.addStep(BoxByFive.B1, first);
        placeByFive.addStep(BoxByFive.B5, second);
        DisplayByFive display = new DisplayByFive(placeByFive);
        display.showPolygon();
        assertThat(out.toString(), containsString(" --- --- --- --- --- " + System.lineSeparator()
                + "|" + " X " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + " O " + "|"
                + System.lineSeparator()
                + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
                + System.lineSeparator()
                + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
                + System.lineSeparator()
                + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
                + System.lineSeparator()
                + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
                + System.lineSeparator()
                + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}