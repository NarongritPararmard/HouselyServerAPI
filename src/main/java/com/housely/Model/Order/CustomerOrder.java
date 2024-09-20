package com.housely.Model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Card.CreditCard;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Address.PaymentAddress;
import com.housely.Model.Shipping.Shipping;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    @Column(nullable = false)
    private String paymentStatus;
    @Column(nullable = false)
    private double totalAmount;


    // Relationship with CreditCard
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditCardNumber", nullable = false)
    private CreditCard creditCard;

    // Relationship with Customer
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    // Relationship with OrderItem
    @JsonManagedReference
    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    // Relationship with PaymentAddress
    @OneToOne(mappedBy = "customerOrder")
    private PaymentAddress paymentAddress;

    // Relationship with Shipping
    @OneToOne(mappedBy = "customerOrder")
    private Shipping shipping;

}
