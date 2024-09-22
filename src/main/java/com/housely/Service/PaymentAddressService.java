package com.housely.Service;

import com.housely.Model.Address.PaymentAddress;
import com.housely.Repository.PaymentAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentAddressService {
    private final PaymentAddressRepository paymentAddressRepository;

    public PaymentAddressService(PaymentAddressRepository paymentAddressRepository) {
        this.paymentAddressRepository = paymentAddressRepository;
    }

    public List<PaymentAddress> findAll() {
        return paymentAddressRepository.findAll();
    }

    public PaymentAddress save(PaymentAddress paymentAddress) {
        return paymentAddressRepository.save(paymentAddress);
    }

    public PaymentAddress findById(Long id) {
        return paymentAddressRepository.findById(id).orElseThrow(() -> new RuntimeException("PaymentAddress not found"));
    }

    public void deleteById(Long id) {
        paymentAddressRepository.deleteById(id);
    }
}
