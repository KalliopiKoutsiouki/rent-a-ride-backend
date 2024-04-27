package unipi.uml.rentaridebackend.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unipi.uml.rentaridebackend.model.Reservation;
import unipi.uml.rentaridebackend.service.ReservationService;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/reservation"})
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/new")
    public Reservation createReservation(@RequestBody Reservation reservationInfo) {
        return reservationService.addReservation(reservationInfo);
    }
}
