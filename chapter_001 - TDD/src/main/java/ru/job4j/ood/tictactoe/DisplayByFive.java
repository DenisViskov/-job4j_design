package ru.job4j.ood.tictactoe;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 23.06.2020
 */
public class DisplayByFive implements UI<BoxByFive> {

    {
        System.out.println("Welcome to Tic tac toe game");
        System.out.println("You play against the computer");
        System.out.println("squares on polygon are number from range 1 to 9");
        System.out.println("for doing steps you need select one of this numbers");
    }

    private final Polygon polygon;
    private final String emptyBox = " --- --- --- --- --- " + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
            + System.lineSeparator()
            + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
            + System.lineSeparator()
            + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
            + System.lineSeparator()
            + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
            + System.lineSeparator()
            + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|" + "   " + "|"
            + System.lineSeparator()
            + " ---" + " ---" + " ---" + " ---" + " ---" + System.lineSeparator();
    private final Map<BoxByFive, Integer> coordinates;
    private final char zeroIntoBox = 'O';
    private final char xIntoBox = 'X';

    public DisplayByFive(Polygon polygon) {
        this.polygon = polygon;
        coordinates = initCoordinates();
    }

    @Override
    public void showPolygon() {
        char[] points = emptyBox.toCharArray();
        Map<BoxByFive, Gamer> map = new TreeMap<>(getComparator());
        map.putAll(polygon.getCurrentMap());
        for (Map.Entry<BoxByFive, Gamer> pair : map.entrySet()) {
            if (pair.getValue() != null) {
                points[coordinates.get(pair.getKey())] = pair.getValue().getFigure().equals(Figure.X)
                        ? xIntoBox : zeroIntoBox;
            }
        }
        System.out.print(points);
    }

    private Comparator<BoxByFive> getComparator() {
        return new Comparator<BoxByFive>() {
            @Override
            public int compare(BoxByFive o1, BoxByFive o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
    }

    private Map<BoxByFive, Integer> initCoordinates() {
        Map<BoxByFive, Integer> result = new HashMap<>(25);
        result.put(BoxByFive.B1, 25);
        result.put(BoxByFive.B2, 29);
        result.put(BoxByFive.B3, 33);
        result.put(BoxByFive.B4, 37);
        result.put(BoxByFive.B5, 41);
        result.put(BoxByFive.B6, 70);
        result.put(BoxByFive.B7, 74);
        result.put(BoxByFive.B8, 78);
        result.put(BoxByFive.B9, 82);
        result.put(BoxByFive.B10, 86);
        result.put(BoxByFive.B11, 115);
        result.put(BoxByFive.B12, 119);
        result.put(BoxByFive.B13, 123);
        result.put(BoxByFive.B14, 127);
        result.put(BoxByFive.B15, 131);
        result.put(BoxByFive.B16, 160);
        result.put(BoxByFive.B17, 164);
        result.put(BoxByFive.B18, 168);
        result.put(BoxByFive.B19, 172);
        result.put(BoxByFive.B20, 176);
        result.put(BoxByFive.B21, 205);
        result.put(BoxByFive.B22, 209);
        result.put(BoxByFive.B23, 213);
        result.put(BoxByFive.B24, 217);
        result.put(BoxByFive.B25, 221);
        return result;
    }
}
