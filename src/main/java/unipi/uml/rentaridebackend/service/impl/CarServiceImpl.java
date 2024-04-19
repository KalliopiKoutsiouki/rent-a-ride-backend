package unipi.uml.rentaridebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Car;
import unipi.uml.rentaridebackend.repository.CarRepository;
import unipi.uml.rentaridebackend.service.CarService;

import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public List<Car> getAllAvailableCars(Date from, Date to) {
        return null;
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
