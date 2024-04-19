package unipi.uml.rentaridebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unipi.uml.rentaridebackend.model.Leaser;

@Repository
public interface LeaserRepository extends JpaRepository<Leaser, Long> {
}
