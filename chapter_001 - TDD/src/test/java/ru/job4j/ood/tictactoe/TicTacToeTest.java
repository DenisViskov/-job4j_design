package ru.job4j.ood.tictactoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TicTacToeTest {

    private final PrintStream console = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteArray = new PrintStream(out);

    @Before
    public void setUp() throws Exception {
        System.setOut(byteArray);
    }

    @Test
    public void whenPersonWinTest() throws IOException {
        Polygon place = new Place();
        Gamer first = new Person(Figure.X, place);
        Gamer second = new Machine(Figure.O, place);
        place.getCurrentMap().put(BoxByThree.B1, first);
        place.getCurrentMap().put(BoxByThree.B2, first);
        place.getCurrentMap().put(BoxByThree.B3, first);
        UI view = new Display(place);
        TicTacToe ticTacToe = new TicTacToe(first, second, place, view);
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        ticTacToe.startingWithPerson();
        assertThat(out.toString(), containsString("Win person"));
    }

    @Test
    public void whenComputerWinTest() throws IOException {
        Polygon place = new Place();
        Gamer first = new Person(Figure.X, place);
        Gamer second = new Machine(Figure.O, place);
        place.getCurrentMap().put(BoxByThree.B1, second);
        place.getCurrentMap().put(BoxByThree.B2, second);
        place.getCurrentMap().put(BoxByThree.B3, second);
        UI view = new Display(place);
        TicTacToe ticTacToe = new TicTacToe(first, second, place, view);
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        ticTacToe.startingWithPerson();
        assertThat(out.toString(), containsString("Win computer"));
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}