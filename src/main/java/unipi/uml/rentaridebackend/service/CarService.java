package unipi.uml.rentaridebackend.service;

import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Car;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface CarService {


    List<Car> getAllCars();

    List<Car> getAllAvailableCars(LocalDate from, LocalDate to);

    Car addCar(Car car);

    Car deleteCar(Car car);

    Car updateCar(Car car);
}
