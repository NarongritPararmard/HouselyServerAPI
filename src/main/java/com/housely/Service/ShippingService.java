package com.housely.Service;

import com.housely.Model.Shipping.Shipping;
import com.housely.Repository.ShippingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {
    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<Shipping> findAll() {
        return shippingRepository.findAll();
    }

    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Shipping findById(Long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipping not found"));
    }

    public void deleteById(Long id) {
        shippingRepository.deleteById(id);
    }
}
