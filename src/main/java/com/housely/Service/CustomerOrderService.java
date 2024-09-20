package com.housely.Service;

import com.housely.Model.Order.CustomerOrder;
import com.housely.Repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    // inject CustomerOrderRepository
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder save(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder findById(Long id) {
        return customerOrderRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        customerOrderRepository.deleteById(id);
    }
}
