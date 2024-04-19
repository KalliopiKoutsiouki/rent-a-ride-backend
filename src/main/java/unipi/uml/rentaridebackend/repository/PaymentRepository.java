package unipi.uml.rentaridebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unipi.uml.rentaridebackend.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
