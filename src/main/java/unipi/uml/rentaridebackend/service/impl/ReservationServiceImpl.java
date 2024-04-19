package unipi.uml.rentaridebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Reservation;
import unipi.uml.rentaridebackend.repository.ReservationRepository;
import unipi.uml.rentaridebackend.service.ReservationService;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public Reservation cancelReservation() {
        return null;
    }

}
