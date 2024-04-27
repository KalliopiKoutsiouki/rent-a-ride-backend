package unipi.uml.rentaridebackend.service.impl;

import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Car;
import unipi.uml.rentaridebackend.model.Reservation;
import unipi.uml.rentaridebackend.repository.CarRepository;
import unipi.uml.rentaridebackend.repository.ReservationRepository;
import unipi.uml.rentaridebackend.service.ReservationService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public ReservationServiceImpl(final ReservationRepository reservationRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        changeCarAvailability(reservation);
        reservation.setPending(true);
        // send notification
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public Reservation cancelReservation() {
        return null;
    }


    private void changeCarAvailability(Reservation reservation) {
       Optional<Car> existingCar = carRepository.findById(reservation.getCar().getId());
       if (existingCar.isPresent()) {
           existingCar.get().setAvailable(false);
           existingCar.get().setFromDate(reservation.getFromDate());
           existingCar.get().setToDate(reservation.getToDate());
           carRepository.save(existingCar.get());
       }
    }

}
