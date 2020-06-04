package ru.job4j.ood.lsp.parking;

/**
 * Interface of Regulator
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.06.2020
 */
public interface Regulator<Car, Place> {

    /**
     * Method should par auto and return place
     *
     * @param car
     * @return place
     */
    Place toPark(Car car);

    /**
     * Method should return car  by given place
     *
     * @param place
     * @return car
     */
    Car getCar(Place place);

    /**
     * Method should check free places in parking
     *
     * @param car
     * @return boolean answer
     */
    boolean hasFreePlace(Car car);
}
