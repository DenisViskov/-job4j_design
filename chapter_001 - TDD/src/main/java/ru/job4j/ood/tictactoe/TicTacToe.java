package ru.job4j.ood.tictactoe;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 11.06.2020
 */
public class TicTacToe implements Regulation<Gamer, Polygon, UI, BoxByThree> {

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
    public void startingWithPerson() throws IOException {
        while (place.getFreePlaces().size() > 0) {
            view.showPolygon();
            try {
                boolean resultOfStep = person.doStep();
                while (!resultOfStep) {
                    System.out.println("Select free number from 1 to 9 range");
                    resultOfStep = person.doStep();
                }
                if (isEnd()) {
                    break;
                }
                computer.doStep();
                if (isEnd()) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        view.showPolygon();
    }

    @Override
    public void startingWithComputer() throws IOException {
        while (place.getFreePlaces().size() != 1) {
            try {
                computer.doStep();
                if (isEnd()) {
                    break;
                }
                view.showPolygon();
                boolean resultOfStep = person.doStep();
                while (!resultOfStep) {
                    System.out.println("Select free number from 1 to 9 range");
                    resultOfStep = person.doStep();
                }
                if (isEnd()) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (place.getFreePlaces().size() == 1) {
            computer.doStep();
            isEnd();
        }
        view.showPolygon();
    }

    @Override
    public boolean isEnd() {
        if (checkHorizontalLine(person) || checkVerticalLine(person) || checkDiagonalLine(person)) {
            System.out.println("Win person");
            return true;
        }
        if (checkHorizontalLine(computer) || checkVerticalLine(computer) || checkDiagonalLine(computer)) {
            System.out.println("Win computer");
            return true;
        }
        return false;
    }

    private boolean checkHorizontalLine(Gamer gamer) {
        return place.getCurrentMap().get(BoxByThree.B1) != null
                && place.getCurrentMap().get(BoxByThree.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B2) != null
                && place.getCurrentMap().get(BoxByThree.B2).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B3) != null
                && place.getCurrentMap().get(BoxByThree.B3).equals(gamer)
                || place.getCurrentMap().get(BoxByThree.B4) != null
                && place.getCurrentMap().get(BoxByThree.B4).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B5) != null
                && place.getCurrentMap().get(BoxByThree.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B6) != null
                && place.getCurrentMap().get(BoxByThree.B6).equals(gamer)
                || place.getCurrentMap().get(BoxByThree.B7) != null
                && place.getCurrentMap().get(BoxByThree.B7).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B8) != null
                && place.getCurrentMap().get(BoxByThree.B8).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B9) != null
                && place.getCurrentMap().get(BoxByThree.B9).equals(gamer);
    }

    private boolean checkVerticalLine(Gamer gamer) {
        return place.getCurrentMap().get(BoxByThree.B1) != null
                && place.getCurrentMap().get(BoxByThree.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B4) != null
                && place.getCurrentMap().get(BoxByThree.B4).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B7) != null
                && place.getCurrentMap().get(BoxByThree.B7).equals(gamer)
                || place.getCurrentMap().get(BoxByThree.B2) != null
                && place.getCurrentMap().get(BoxByThree.B2).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B5) != null
                && place.getCurrentMap().get(BoxByThree.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B8) != null
                && place.getCurrentMap().get(BoxByThree.B8).equals(gamer)
                || place.getCurrentMap().get(BoxByThree.B3) != null
                && place.getCurrentMap().get(BoxByThree.B3).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B6) != null
                && place.getCurrentMap().get(BoxByThree.B6).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B9) != null
                && place.getCurrentMap().get(BoxByThree.B9).equals(gamer);
    }

    private boolean checkDiagonalLine(Gamer gamer) {
        return place.getCurrentMap().get(BoxByThree.B1) != null
                && place.getCurrentMap().get(BoxByThree.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B5) != null
                && place.getCurrentMap().get(BoxByThree.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B9) != null
                && place.getCurrentMap().get(BoxByThree.B9).equals(gamer)
                || place.getCurrentMap().get(BoxByThree.B3) != null
                && place.getCurrentMap().get(BoxByThree.B3).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B5) != null
                && place.getCurrentMap().get(BoxByThree.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByThree.B7) != null
                && place.getCurrentMap().get(BoxByThree.B7).equals(gamer);
    }

    public static void main(String[] args) throws IOException {
        Polygon polygon = new Place();
        TicTacToe ticTacToe = new TicTacToe(new Person(Figure.X, polygon),
                new Machine(Figure.O, polygon), polygon, new Display(polygon));
        ticTacToe.startingWithPerson();
    }
}
