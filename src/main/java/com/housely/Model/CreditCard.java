package com.housely.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CreditCard {
    @Id
    private String creditCartNumber;
    @Column(nullable = false)
    private String yearExp;
    @Column(nullable = false)
    private String monthExp;
    @Column(nullable = false)
    private String CVV;

    @ManyToMany(mappedBy = "creditCards")
    private List<Customer> customers;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders;




}
