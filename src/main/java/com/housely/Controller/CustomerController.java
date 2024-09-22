package com.housely.Controller;

import com.housely.Model.Customer.Customer;
import com.housely.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public @ResponseBody List<Customer> getAllCustomer() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public @ResponseBody Customer addCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
      customer.setId(id);
      return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteCustomer(@PathVariable Long id) {
        if (customerService.findById(id) != null) {
            customerService.deleteById(id);
        }
        return String.format("Customer Id:%d was delete successfully!", id);
    }
}
