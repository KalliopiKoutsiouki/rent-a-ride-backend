package unipi.uml.rentaridebackend.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import unipi.uml.rentaridebackend.model.Car;
import unipi.uml.rentaridebackend.service.CarService;

import java.time.LocalDate;
import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/car"})
public class CarController {


    private final CarService carService;

    public CarController(final CarService carService) {
        this.carService = carService;
    }


    @GetMapping({"/all"})
    public List<Car> getAllCars() {
        return this.carService.getAllCars();
    }

    @GetMapping({"/available/{from}/{to}"})
    public List<Car> getAllAvailableCars( @PathVariable("from") @DateTimeFormat(pattern = "yyyy-MM-dd") String from,
                                          @PathVariable("to") @DateTimeFormat(pattern = "yyyy-MM-dd") String to) {
        LocalDate fromDateParsed = LocalDate.parse(from);
        LocalDate toDateParsed = LocalDate.parse(to);
        return this.carService.getAllAvailableCars(fromDateParsed,toDateParsed );
    }

}
