package ru.job4j.ood.lsp.parking;

import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 05.06.2020
 */
public class TrafficOwner implements Regulator<Car, Place> {

    private final Parking parking;

    public TrafficOwner(Parking parking) {
        this.parking = parking;
    }

    @Override
    public Place toPark(Car car) {
        if (!hasFreePlace(car)) {
            System.out.println("Not places");
            return null;
        }
        return (Place) (car instanceof Automobile ? parking.addCar(car)
                : parking.addTruck(car));
    }

    @Override
    public Car getCar(Place place) {
        return (Car) parking.leaveCar(place);
    }

    @Override
    public boolean hasFreePlace(Car car) {
        Optional<Place> box = Optional.ofNullable((Place) parking.findPlace(car));
        return box.isPresent() ? true : false;
    }
}
