package unipi.uml.rentaridebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.uml.rentaridebackend.model.Payment;
import unipi.uml.rentaridebackend.repository.PaymentRepository;
import unipi.uml.rentaridebackend.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment createPayment(Payment payment) {
        return null;
    }
}
