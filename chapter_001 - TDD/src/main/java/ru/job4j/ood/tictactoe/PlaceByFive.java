package ru.job4j.ood.tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 23.06.2020
 */
public class PlaceByFive implements Polygon<BoxByFive, Gamer> {

    private Map<BoxByFive, Gamer> map;

    public PlaceByFive() {
        initMap();
    }

    @Override
    public boolean addStep(BoxByFive box, Gamer gamer) {
        boolean result = false;
        if (isReserved(box) || box == null) {
            return result;
        }
        map.put(box, gamer);
        result = true;
        return result;
    }

    @Override
    public List<BoxByFive> getFreePlaces() {
        return map.entrySet().stream()
                .filter(box -> box.getValue() == null)
                .map(box -> box.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public Map<BoxByFive, Gamer> getCurrentMap() {
        return map;
    }

    private void initMap() {
        map = new HashMap<>(25);
        Arrays.stream(BoxByFive.values())
                .forEach(box -> map.put(box, null));
    }

    private boolean isReserved(BoxByFive box) {
        return map.get(box) == null ? false : true;
    }
}
