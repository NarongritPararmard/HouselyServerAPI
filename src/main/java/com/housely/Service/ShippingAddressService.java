package com.housely.Service;

import com.housely.Model.Address.ShippingAddress;
import com.housely.Repository.ShippingAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;

    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    public List<ShippingAddress> findAll() {
        return shippingAddressRepository.findAll();
    }

    public ShippingAddress save(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }

    public ShippingAddress findById(Long id) {
        return shippingAddressRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        shippingAddressRepository.deleteById(id);
    }
}
