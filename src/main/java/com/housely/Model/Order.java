package com.housely.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    @Column(nullable = false)
    private String paymentStatus;
    @Column(nullable = false)
    private double totalAmount;


    // Relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "creditCardId", nullable = false)
    private CreditCard creditCard;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @JsonManagedReference
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order")
    private PaymentAddress paymentAddress;

    @OneToOne(mappedBy = "order")
    private Shipping shipping;

}
