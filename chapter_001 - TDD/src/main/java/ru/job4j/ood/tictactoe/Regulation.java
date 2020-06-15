package ru.job4j.ood.tictactoe;

import java.io.IOException;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 10.06.2020
 */
public interface Regulation<Gamer, Polygon, UI, Box> {

    void startingWithPerson() throws IOException;

    void startingWithComputer() throws IOException;

    boolean isEnd();
}
