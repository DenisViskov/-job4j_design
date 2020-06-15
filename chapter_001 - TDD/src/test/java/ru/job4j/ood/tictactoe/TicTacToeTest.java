package ru.job4j.ood.tictactoe;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TicTacToeTest {

    @Test
    public void startTest() throws IOException {
        Polygon place = new Place();
        Gamer first = new Person(Figure.X, place);
        Gamer second = new Machine(Figure.O, place);
        UI view = new Display(place);
        TicTacToe ticTacToe = new TicTacToe(first, second, place, view);
        ticTacToe.startingWithPerson();
    }

    @Test
    public void endTest() {
    }
}