package ru.job4j.ood.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DisplayByThreeTest {

    private final PrintStream console = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteArray = new PrintStream(out);

    @Before
    public void setUp() throws Exception {
        System.setOut(byteArray);
    }

    @Test
    public void showPolygonTest() {
        PlaceByThree placeByThree = new PlaceByThree();
        Gamer first = new Person(Figure.X, placeByThree);
        Gamer second = new Machine(Figure.O, placeByThree);
        placeByThree.addStep(BoxByThree.B1, first);
        placeByThree.addStep(BoxByThree.B5, second);
        DisplayByThree displayByThree = new DisplayByThree(placeByThree);
        displayByThree.showPolygon();
        assertThat(out.toString(), containsString(" --- --- --- " + System.lineSeparator()
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