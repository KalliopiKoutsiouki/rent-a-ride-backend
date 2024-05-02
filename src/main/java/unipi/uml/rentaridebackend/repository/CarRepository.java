package unipi.uml.rentaridebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unipi.uml.rentaridebackend.model.Car;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

//    @Query("SELECT c FROM Car c WHERE c.isAvailable = true AND c.fromDate <= :toDate AND c.toDate >= :fromDate")
//    List<Car> findAllAvailableCarsFromDateToDate(LocalDate fromDate, LocalDate toDate);

    List<Car> findAllByIsAvailableTrueAndFromDateGreaterThanEqualAndToDateLessThanEqual(LocalDate fromDate, LocalDate toDate);
}
