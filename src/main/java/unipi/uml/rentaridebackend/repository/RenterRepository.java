package unipi.uml.rentaridebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unipi.uml.rentaridebackend.model.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {


}
