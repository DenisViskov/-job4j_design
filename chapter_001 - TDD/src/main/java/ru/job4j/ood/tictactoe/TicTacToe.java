package ru.job4j.ood.tictactoe;

import java.io.IOException;
import java.util.Map;

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
        while (place.getFreePlaces().size() > 0 && !isEnd()) {
            view.showPolygon();
            try {
                boolean resultOfStep = person.doStep();
                while (!resultOfStep) {
                    System.out.println("Select free number from 1 to 9 range");
                    resultOfStep = person.doStep();
                }
                computer.doStep();
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
                view.showPolygon();
                boolean resultOfStep = person.doStep();
                while (!resultOfStep) {
                    System.out.println("Select free number from 1 to 9 range");
                    resultOfStep = person.doStep();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        computer.doStep();
        view.showPolygon();
    }

    @Override
    public boolean isEnd() {
        return checkHorizontalLine(person);
    }

    private boolean checkHorizontalLine(Gamer gamer) {
        boolean result = false;
        boolean temp = true;
        int count = 0;
        BoxByThree[] boxes = BoxByThree.values();
        for (int i = 0; i < boxes.length; i++) {
            if (result) {
                break;
            }
            if (count == 3) {
                temp = true;
            }
            if (place.getCurrentMap().get(boxes[i]) == null
                    || !place.getCurrentMap().get(boxes[i]).equals(gamer)) {
                temp = false;
            }
            count = count < 3 ? ++count : 0;
            result = temp && count == 3 ? true : false;
        }
        return result;
    }

    private boolean checkVerticalLine(Gamer gamer) {
        return false;
    }

    public static void main(String[] args) throws IOException {
        Polygon polygon = new Place();
        TicTacToe ticTacToe = new TicTacToe(new Person(Figure.X, polygon),
                new Machine(Figure.O, polygon), polygon, new Display(polygon));
        ticTacToe.startingWithPerson();
    }
}
