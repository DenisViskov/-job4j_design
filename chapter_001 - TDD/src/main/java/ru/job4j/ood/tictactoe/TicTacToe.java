package ru.job4j.ood.tictactoe;

import java.io.IOException;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 11.06.2020
 */
public class TicTacToe implements Regulation<Gamer, Polygon, UI> {

    private final Gamer person;
    private final Gamer computer;
    private final Polygon place;
    private final UI view;

    {
        System.out.println("Welcome to Tic tac toe game");
        System.out.println("You play against the computer");
        System.out.println("squares on polygon are number from range 1 to 9");
        System.out.println("for doing steps you need select one of this numbers");
    }

    public TicTacToe(Gamer person, Gamer computer, Polygon place, UI view) {
        this.person = person;
        this.computer = computer;
        this.place = place;
        this.view = view;
    }

    @Override
    public void start() {
        while (place.getFreePlaces().size() > 0) {
            view.showPolygon();
            try {
                boolean resultOfStep = person.doStep();
                while (!resultOfStep) {
                    System.out.println("Select number from 1 to 9 range");
                    resultOfStep = person.doStep();
                }
                computer.doStep();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void end() {

    }
}
