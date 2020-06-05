package ru.job4j.ood.lsp.parking;

/**
 * Interface of parking
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.06.2020
 */
public interface Parking<Place, Car> {

    /**
     * Method should park given car to parking
     *
     * @param car
     * @return Place
     */
    Place addCar(Car car);

    /**
     * Method should park given car to parking
     *
     * @param truck
     * @return Place
     */
    Place addTruck(Car truck);

    /**
     * Method should return car from parking
     *
     * @param place
     * @return Car
     */
    Car leaveCar(Place place);

    /**
     * Method should looking for place
     *
     * @param car
     * @return place
     */
    Place findPlace(Car car);
}
