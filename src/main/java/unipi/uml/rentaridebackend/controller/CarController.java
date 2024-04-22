package unipi.uml.rentaridebackend.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unipi.uml.rentaridebackend.model.Car;
import unipi.uml.rentaridebackend.service.CarService;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/car"})
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping({"/all"})
    public List<Car> getAllCars() {
        return this.carService.getAllCars();
    }

}
