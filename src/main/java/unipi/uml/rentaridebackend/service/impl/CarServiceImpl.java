package unipi.uml.rentaridebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Car;
import unipi.uml.rentaridebackend.repository.CarRepository;
import unipi.uml.rentaridebackend.service.CarService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    public CarServiceImpl(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return Optional.of(carRepository.findAll())
                .orElseThrow(() -> new RuntimeException("No cars found."));

    }

    @Override
    public List<Car> getAllAvailableCars(LocalDate from, LocalDate to) {
        return Optional.of(carRepository.findAllByIsAvailableTrueAndFromDateGreaterThanEqualAndToDateLessThanEqual(from, to))
                .orElseThrow(() -> new RuntimeException("No available cars found for: " + from.toString() + " - " + to.toString()));
    }

    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public Car deleteCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }


}
