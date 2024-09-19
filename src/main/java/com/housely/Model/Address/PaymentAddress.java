package com.housely.Model.Address;

import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
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
public class PaymentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentAddressId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String streetAlleyVillage;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkToOrderId", referencedColumnName = "orderId")
    private CustomerOrder customerOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkToCusId", referencedColumnName = "id")
    private Customer customer;

}
