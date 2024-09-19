package com.housely.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shippingId;
    @Column(nullable = false)
    private String targetFirstName;
    @Column(nullable = false)
    private String targetLastName;
    @Column(nullable = false)
    private String targetPhoneNumber;
    @Column(nullable = false)
    private String shippingStatus;
    @Column(nullable = false)
    private LocalDate shippingDate;
    @Column(nullable = false)
    private String shippingMethod;
    @Column(nullable = false)
    private String trackingNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;
}
