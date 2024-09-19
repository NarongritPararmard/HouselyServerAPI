package com.housely.Model.Address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Shipping.Shipping;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingIdFK", referencedColumnName = "shippingId")
    private Shipping shipping;

}
