package ru.job4j.ood.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DisplayTest {

    @Test
    public void showPolygonTest() {
        Place place = new Place();
        Gamer first = new Person(Figure.X, place);
        Gamer second = new Machine(Figure.O, place);
        place.addStep(BoxByThree.B1, first);
        place.addStep(BoxByThree.B5, second);
        Display display = new Display(place);
        display.showPolygon();
    }
}