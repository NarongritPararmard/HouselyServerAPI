package com.housely.Serevice;

import com.housely.Model.Customer.Customer;
import com.housely.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }
}
