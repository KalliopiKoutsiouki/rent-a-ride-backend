package unipi.uml.rentaridebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Reservation;

import java.util.List;

@Service
public interface ReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> getAll();

    Reservation cancelReservation();

}
