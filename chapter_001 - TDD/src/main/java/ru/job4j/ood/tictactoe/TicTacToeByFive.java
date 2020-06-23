package ru.job4j.ood.tictactoe;

import java.io.IOException;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 23.06.2020
 */
public class TicTacToeByFive implements Regulation<Gamer, Polygon, UI, BoxByFive> {
    private final Gamer person;
    private final Gamer computer;
    private final Polygon place;
    private final UI view;

    public TicTacToeByFive(Gamer person, Gamer computer, Polygon place, UI view) {
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
        return place.getCurrentMap().get(BoxByFive.B1) != null
                && place.getCurrentMap().get(BoxByFive.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B2) != null
                && place.getCurrentMap().get(BoxByFive.B2).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B3) != null
                && place.getCurrentMap().get(BoxByFive.B3).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B4) != null
                && place.getCurrentMap().get(BoxByFive.B4).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B5) != null
                && place.getCurrentMap().get(BoxByFive.B5).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B6) != null
                && place.getCurrentMap().get(BoxByFive.B6).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B7) != null
                && place.getCurrentMap().get(BoxByFive.B7).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B8) != null
                && place.getCurrentMap().get(BoxByFive.B8).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B9) != null
                && place.getCurrentMap().get(BoxByFive.B9).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B10) != null
                && place.getCurrentMap().get(BoxByFive.B10).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B11) != null
                && place.getCurrentMap().get(BoxByFive.B11).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B12) != null
                && place.getCurrentMap().get(BoxByFive.B12).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B13) != null
                && place.getCurrentMap().get(BoxByFive.B13).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B14) != null
                && place.getCurrentMap().get(BoxByFive.B14).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B15) != null
                && place.getCurrentMap().get(BoxByFive.B15).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B16) != null
                && place.getCurrentMap().get(BoxByFive.B16).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B17) != null
                && place.getCurrentMap().get(BoxByFive.B17).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B18) != null
                && place.getCurrentMap().get(BoxByFive.B18).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B19) != null
                && place.getCurrentMap().get(BoxByFive.B19).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B20) != null
                && place.getCurrentMap().get(BoxByFive.B20).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B21) != null
                && place.getCurrentMap().get(BoxByFive.B21).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B22) != null
                && place.getCurrentMap().get(BoxByFive.B22).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B23) != null
                && place.getCurrentMap().get(BoxByFive.B23).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B24) != null
                && place.getCurrentMap().get(BoxByFive.B24).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B25) != null
                && place.getCurrentMap().get(BoxByFive.B25).equals(gamer);
    }

    private boolean checkVerticalLine(Gamer gamer) {
        return place.getCurrentMap().get(BoxByFive.B1) != null
                && place.getCurrentMap().get(BoxByFive.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B6) != null
                && place.getCurrentMap().get(BoxByFive.B6).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B11) != null
                && place.getCurrentMap().get(BoxByFive.B11).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B16) != null
                && place.getCurrentMap().get(BoxByFive.B16).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B21) != null
                && place.getCurrentMap().get(BoxByFive.B21).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B2) != null
                && place.getCurrentMap().get(BoxByFive.B2).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B7) != null
                && place.getCurrentMap().get(BoxByFive.B7).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B12) != null
                && place.getCurrentMap().get(BoxByFive.B12).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B17) != null
                && place.getCurrentMap().get(BoxByFive.B17).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B22) != null
                && place.getCurrentMap().get(BoxByFive.B22).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B3) != null
                && place.getCurrentMap().get(BoxByFive.B3).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B8) != null
                && place.getCurrentMap().get(BoxByFive.B8).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B13) != null
                && place.getCurrentMap().get(BoxByFive.B13).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B18) != null
                && place.getCurrentMap().get(BoxByFive.B18).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B23) != null
                && place.getCurrentMap().get(BoxByFive.B23).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B4) != null
                && place.getCurrentMap().get(BoxByFive.B4).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B9) != null
                && place.getCurrentMap().get(BoxByFive.B9).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B14) != null
                && place.getCurrentMap().get(BoxByFive.B14).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B19) != null
                && place.getCurrentMap().get(BoxByFive.B19).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B24) != null
                && place.getCurrentMap().get(BoxByFive.B24).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B5) != null
                && place.getCurrentMap().get(BoxByFive.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B10) != null
                && place.getCurrentMap().get(BoxByFive.B10).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B15) != null
                && place.getCurrentMap().get(BoxByFive.B15).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B20) != null
                && place.getCurrentMap().get(BoxByFive.B20).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B25) != null
                && place.getCurrentMap().get(BoxByFive.B25).equals(gamer);
    }

    private boolean checkDiagonalLine(Gamer gamer) {
        return place.getCurrentMap().get(BoxByFive.B1) != null
                && place.getCurrentMap().get(BoxByFive.B1).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B7) != null
                && place.getCurrentMap().get(BoxByFive.B7).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B13) != null
                && place.getCurrentMap().get(BoxByFive.B13).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B19) != null
                && place.getCurrentMap().get(BoxByFive.B19).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B25) != null
                && place.getCurrentMap().get(BoxByFive.B25).equals(gamer)
                || place.getCurrentMap().get(BoxByFive.B5) != null
                && place.getCurrentMap().get(BoxByFive.B5).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B9) != null
                && place.getCurrentMap().get(BoxByFive.B9).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B13) != null
                && place.getCurrentMap().get(BoxByFive.B13).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B17) != null
                && place.getCurrentMap().get(BoxByFive.B17).equals(gamer)
                && place.getCurrentMap().get(BoxByFive.B20) != null
                && place.getCurrentMap().get(BoxByFive.B20).equals(gamer);
    }

    public static void main(String[] args) throws IOException {
        Polygon polygon = new PlaceByFive();
        TicTacToeByFive ticTacToe = new TicTacToeByFive(new Person(Figure.X, polygon),
                new Machine(Figure.O, polygon), polygon, new DisplayByFive(polygon));
        ticTacToe.startingWithPerson();
    }
}
