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
    private final String emptyBox = " --- "
            + System.lineSeparator()
            + "|" + "   " + "|"
            + System.lineSeparator()
            + " --- ";
    private final String zeroIntoBox = " --- "
            + System.lineSeparator()
            + "|" + " O " + "|"
            + System.lineSeparator()
            + " --- ";
    private final String xIntoBox = " --- "
            + System.lineSeparator()
            + "|" + " X " + "|"
            + System.lineSeparator()
            + " --- ";

    public Display(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void showPolygon() {
        Map<BoxByThree, Gamer> map = new TreeMap<>(getComparator());
        map.putAll(polygon.getCurrentMap());
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (Map.Entry<BoxByThree, Gamer> pair : map.entrySet()) {
            if (count == 3) {
                builder.append(System.lineSeparator());
                count = 1;
            }
            if (pair.getValue() == null) {
                builder.append(emptyBox);
            }
            if (pair.getValue() != null) {
                builder.append(pair.getValue().getFigure().equals(Figure.X)
                        ? xIntoBox : zeroIntoBox);
            }
            count++;
        }
        System.out.println(builder);
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
