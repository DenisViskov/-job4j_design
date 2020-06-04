package ru.job4j.ood.lsp.parking;

/**
 * Interface of Car
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.06.2020
 */
public interface Car {

    /**
     * Method should drive a car
     */
    void run();

    /**
     * Method should return number of car
     *
     * @return - number
     */
    int getNumber();

    /**
     * Method should return size
     *
     * @return - size
     */
    int size();
}
