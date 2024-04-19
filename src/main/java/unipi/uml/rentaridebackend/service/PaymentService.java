package unipi.uml.rentaridebackend.service;

import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Payment;

@Service
public interface PaymentService {

    Payment createPayment(Payment payment);

}
