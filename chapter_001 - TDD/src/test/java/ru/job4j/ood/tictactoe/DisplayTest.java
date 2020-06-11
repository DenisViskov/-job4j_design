package ru.job4j.ood.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DisplayTest {

    private final PrintStream console = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteArray = new PrintStream(out);

    @Before
    public void setUp() throws Exception {
        System.setOut(byteArray);
    }

    @Test
    public void showPolygonTest() {
        Place place = new Place();
        Gamer first = new Person(Figure.X, place);
        Gamer second = new Machine(Figure.O, place);
        place.addStep(BoxByThree.B1, first);
        place.addStep(BoxByThree.B5, second);
        Display display = new Display(place);
        display.showPolygon();
        assertThat(out.toString(), is(" --- --- --- " + System.lineSeparator()
                + "|" + " X " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
                + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + " O " + "|" + "   " + "|" + System.lineSeparator()
                + " ---" + " ---" + " ---" + System.lineSeparator()
                + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
                + " ---" + " ---" + " ---" + System.lineSeparator()));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}