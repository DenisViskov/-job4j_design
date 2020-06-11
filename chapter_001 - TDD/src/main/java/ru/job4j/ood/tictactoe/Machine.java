package ru.job4j.ood.tictactoe;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 10.06.2020
 */
public class Machine implements Gamer<Figure, Polygon> {

    private final Figure figure;
    private final Polygon polygon;

    public Machine(Figure figure, Polygon polygon) {
        this.figure = figure;
        this.polygon = polygon;
    }

    @Override
    public boolean doStep() throws IOException {
       return polygon.addStep(choose(polygon.getFreePlaces()), this);
    }

    @Override
    public Figure getFigure() {
        return figure;
    }

    private BoxByThree choose(List<BoxByThree> free) {
        return BoxByThree.values()[new Random().nextInt(free.size())];
    }
}
