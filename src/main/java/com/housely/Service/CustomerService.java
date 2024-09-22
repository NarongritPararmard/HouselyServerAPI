package com.housely.Service;

import com.housely.Model.Customer.Customer;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Repository.CustomerRepository;
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
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }

//    public List<FavoriteList> findFavoritesByCustomerId(Long customerId){
//        return customerRepository.findFavoritesByCustomerId(customerId).orElse(null);
//    }
}
