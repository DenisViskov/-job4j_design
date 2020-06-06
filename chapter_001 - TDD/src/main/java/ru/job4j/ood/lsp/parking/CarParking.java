package ru.job4j.ood.lsp.parking;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class of parking
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.06.2020
 */
public class CarParking implements Parking<Place, Car> {

    /**
     * Car places
     */
    private final List<Place> carPlace;

    /**
     * Truck places
     */
    private final List<Place> truckPlace;

    public CarParking(int car, int truck) {
        carPlace = initCarPlace(car);
        truckPlace = initTruckPlace(truck);
    }

    /**
     * Method adds a car into box of parking
     *
     * @param car
     * @return place
     */
    @Override
    public Place addCar(Car car) {
        Optional<Place> box = Optional.ofNullable(findPlace(car));
        box.ifPresent(place -> place.setCar(car));
        return box.orElse(null);
    }

    /**
     * Method adds truck into box of parking
     *
     * @param truck
     * @return place
     */
    @Override
    public Place addTruck(Car truck) {
        Optional<Place> box = Optional.ofNullable(findPlace(truck));
        box.ifPresent(place -> place.setCar(truck));
        return box.orElse(null);
    }

    /**
     * Method export car by given place from box
     *
     * @param place
     * @return car
     */
    @Override
    public Car leaveCar(Place place) {
        Place placeBox = Stream.of(carPlace, truckPlace)
                .flatMap(places -> places.stream())
                .filter(box -> box.equals(place))
                .findFirst().get();
        Car car = placeBox.getCar();
        placeBox.setCar(null);
        return car;
    }

    /**
     * Method for initialization list of places
     *
     * @param size
     * @return list
     */
    private List<Place> initCarPlace(int size) {
        List<Place> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Place(Place.PlaceFor.Car, i + 1, 4));
        }
        return result;
    }

    /**
     * Method for initialization list of places
     *
     * @param size
     * @return list
     */
    private List<Place> initTruckPlace(int size) {
        List<Place> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Place(Place.PlaceFor.Truck, i + 1, 6));
        }
        return result;
    }

    /**
     * Method looking for free places for car
     *
     * @param car
     * @return place
     */
    @Override
    public Place findPlace(Car car) {
        Place place = null;
        if (car.size() <= 4) {
            place = Stream.of(carPlace, truckPlace)
                    .flatMap(places -> places.stream())
                    .filter(places -> places.getCar() == null)
                    .findFirst().get();
        }
        if (car.size() > 4 && car.size() <= 6) {
            place = truckPlace.stream()
                    .filter(places -> places.getCar() == null)
                    .findFirst().get();
        }
        return place;
    }
}
