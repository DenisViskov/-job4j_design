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

    /**
     * Parking
     */
    private Map<Place, Car> parking;

    public CarParking(int car, int truck) {
        carPlace = initCarPlace(car);
        truckPlace = initTruckPlace(truck);
        parking = initParkingPlace(carPlace, truckPlace);
    }

    /**
     * Method adds a car into map of parking
     *
     * @param car
     * @return place
     */
    @Override
    public Place addCar(Car car) {
        Optional<Place> box = Optional.ofNullable(findPlace(car));
        box.ifPresent(place -> parking.replace(place, null, car));
        return box.orElse(null);
    }

    /**
     * Method adds truck into map of parking
     *
     * @param truck
     * @return place
     */
    @Override
    public Place addTruck(Car truck) {
        Optional<Place> box = Optional.ofNullable(findPlace(truck));
        box.ifPresent(place -> parking.replace(place, null, truck));
        return box.orElse(null);
    }

    /**
     * Method export car by given place from map of parking
     *
     * @param place
     * @return car
     */
    @Override
    public Car leaveCar(Place place) {
        Car car = parking.get(place);
        parking.replace(place, car, null);
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
            result.add(new Place(Place.PlaceFor.Car, i + 1));
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
            result.add(new Place(Place.PlaceFor.Truck, i + 1));
        }
        return result;
    }

    /**
     * Method for initialization map of parking
     *
     * @param carPlaces
     * @param truckPlaces
     * @return map
     */
    private Map<Place, Car> initParkingPlace(List<Place> carPlaces, List<Place> truckPlaces) {
        Map<Place, Car> result = new HashMap<>();
        carPlaces.forEach(place -> result.put(place, null));
        truckPlaces.forEach(place -> result.put(place, null));
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
        if (car instanceof Automobile) {
            Optional<Place> box = Optional
                    .ofNullable(findFirst(Place.PlaceFor.Car));
            place = box.orElse(findFirst(Place.PlaceFor.Truck));
        }
        if (car instanceof Truck) {
            place = findFirst(Place.PlaceFor.Truck);
        }
        return place;
    }

    /**
     * Method looking for first free place by given type of car
     *
     * @param car
     * @return place
     */
    private Place findFirst(Place.PlaceFor car) {
        Place place = null;
        for (Map.Entry<Place, Car> pair : parking.entrySet()) {
            if (pair.getKey().getType().equals(car)
                    && pair.getValue() == null) {
                place = pair.getKey();
                break;
            }
        }
        return place;
    }
}
