package com.housely.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shippingAddressId;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String province;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String streetAlleyVillage;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

}
