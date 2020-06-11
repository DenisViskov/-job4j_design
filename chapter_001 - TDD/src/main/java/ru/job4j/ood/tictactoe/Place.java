package ru.job4j.ood.tictactoe;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 10.06.2020
 */
public class Place implements Polygon<BoxByThree, Gamer> {

    private Map<BoxByThree, Gamer> map;

    public Place() {
        map = new HashMap<>(9);
        map.put(BoxByThree.B1, null);
        map.put(BoxByThree.B2, null);
        map.put(BoxByThree.B3, null);
        map.put(BoxByThree.B4, null);
        map.put(BoxByThree.B5, null);
        map.put(BoxByThree.B6, null);
        map.put(BoxByThree.B7, null);
        map.put(BoxByThree.B8, null);
        map.put(BoxByThree.B9, null);
    }

    @Override
    public boolean addStep(BoxByThree box, Gamer gamer) {
        boolean result = false;
        if (isReserved(box)) {
            return result;
        }
        map.put(box, gamer);
        result = true;
        return result;
    }

    @Override
    public List<BoxByThree> getFreePlaces() {
        return map.entrySet().stream()
                .filter(box -> box.getValue() == null)
                .map(box -> box.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public Map<BoxByThree, Gamer> getCurrentMap() {
        return map;
    }

    private boolean isReserved(BoxByThree box) {
        return map.get(box) == null ? false : true;
    }

    @Override
    public String toString() {
        if (!map.containsValue(Gamer.class)) {
            return " --- --- --- " + System.lineSeparator()
                    + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
                    + " ---" + " ---" + " ---" + System.lineSeparator()
                    + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
                    + " ---" + " ---" + " ---" + System.lineSeparator()
                    + "|" + "   " + "|" + "   " + "|" + "   " + "|" + System.lineSeparator()
                    + " ---" + " ---" + " ---" + System.lineSeparator();

        }
        return null;
    }
}
