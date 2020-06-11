package ru.job4j.ood.tictactoe;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 10.06.2020
 */
public interface Polygon<Place, Gamer> {

    boolean addStep(Place box, Gamer gamer);

    List<Place> getFreePlaces();

    Map<Place, Gamer> getCurrentMap();
}
