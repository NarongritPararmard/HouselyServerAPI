package com.housely.Model.Shipping;

import com.housely.Model.Address.ShippingAddress;
import com.housely.Model.Order.CustomerOrder;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private CustomerOrder customerOrder;

    @OneToOne(mappedBy = "shipping")
    private ShippingAddress shippingAddress;
}
