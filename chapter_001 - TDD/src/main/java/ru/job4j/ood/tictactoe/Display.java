package ru.job4j.ood.tictactoe;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 11.06.2020
 */
public class Display implements UI<BoxByThree> {

    private final Polygon polygon;
    private final String emptyBox = " --- --- --- " + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
            + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
            + " ---" + " ---" + " ---" + System.lineSeparator()
            + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
            + " ---" + " ---" + " ---" + System.lineSeparator();
    private final Map<BoxByThree, Integer> coordinates = Map.of(BoxByThree.B1, 17,
            BoxByThree.B2, 21,
            BoxByThree.B3, 25,
            BoxByThree.B4, 46,
            BoxByThree.B5, 50,
            BoxByThree.B6, 54,
            BoxByThree.B7, 75,
            BoxByThree.B8, 79,
            BoxByThree.B9, 83);
    private final char zeroIntoBox = 'O';
    private final char xIntoBox = 'X';

    public Display(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void showPolygon() {
        char[] points = emptyBox.toCharArray();
        Map<BoxByThree, Gamer> map = new TreeMap<>(getComparator());
        map.putAll(polygon.getCurrentMap());
        for (Map.Entry<BoxByThree, Gamer> pair : map.entrySet()) {
            if (pair.getValue() != null) {
                points[coordinates.get(pair.getKey())] = pair.getValue().getFigure().equals(Figure.X)
                        ? xIntoBox : zeroIntoBox;
            }
        }
        System.out.print(points);
    }

    private Comparator<BoxByThree> getComparator() {
        return new Comparator<BoxByThree>() {
            @Override
            public int compare(BoxByThree o1, BoxByThree o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
    }
}
