package ru.job4j.ood.lsp.parking;

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
        return null;
    }

    @Override
    public Car getCar(Place place) {
        return null;
    }

    @Override
    public boolean hasFreePlace(Car car) {
        return false;
    }
}
