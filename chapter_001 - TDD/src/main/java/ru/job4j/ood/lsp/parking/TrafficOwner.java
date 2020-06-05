package ru.job4j.ood.lsp.parking;

import java.util.Optional;

/**
 * Class of traffic control
 *
 * @author Денис Висков
 * @version 1.0
 * @since 05.06.2020
 */
public class TrafficOwner implements Regulator<Car, Place> {

    /**
     * Parking
     */
    private final Parking parking;

    public TrafficOwner(Parking parking) {
        this.parking = parking;
    }

    /**
     * Method execute check free places and park auto
     *
     * @param car
     * @return place
     */
    @Override
    public Place toPark(Car car) {
        if (!hasFreePlace(car)) {
            System.out.println("Not places");
            return null;
        }
        return (Place) (car instanceof Automobile ? parking.addCar(car)
                : parking.addTruck(car));
    }

    /**
     * Method return auto from parking
     *
     * @param place
     * @return car
     */
    @Override
    public Car getCar(Place place) {
        return (Car) parking.leaveCar(place);
    }

    /**
     * Method of check free places in parking
     *
     * @param car
     * @return - boolean answer
     */
    @Override
    public boolean hasFreePlace(Car car) {
        Optional<Place> box = Optional.ofNullable((Place) parking.findPlace(car));
        return box.isPresent() ? true : false;
    }
}
