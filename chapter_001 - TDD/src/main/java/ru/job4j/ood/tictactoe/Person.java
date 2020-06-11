package ru.job4j.ood.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 10.06.2020
 */
public class Person implements Gamer<Figure, Polygon> {

    private final Figure figure;
    private final Polygon polygon;

    public Person(Figure figure, Polygon polygon) {
        this.figure = figure;
        this.polygon = polygon;
    }

    @Override
    public boolean doStep() throws IOException {
        boolean result = false;
        try (Scanner scanner = new Scanner(System.in)) {
            int selected = scanner.nextInt();
            if (validateInput(selected)) {
                result = polygon.addStep(stepOn(selected), this);
            }
        }
        return result;
    }

    private BoxByThree stepOn(int selected) {
        return BoxByThree.values()[selected - 1];
    }

    private boolean validateInput(int selected) {
        return selected < 10 && selected > 0 ? true : false;
    }
}
