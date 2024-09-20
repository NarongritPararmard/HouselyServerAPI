package com.housely.Model.Card;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CreditCard {
    @Id
    private String creditCardNumber;
    @Column(nullable = false)
    private String yearExp;
    @Column(nullable = false)
    private String monthExp;
    @Column(nullable = false)
    private String CVV;

    @ManyToMany(mappedBy = "creditCards")
    private List<Customer> customers;

    @JsonManagedReference
    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrders;

}
