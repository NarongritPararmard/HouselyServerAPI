package com.housely.Model.Customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Address.PaymentAddress;
import com.housely.Model.Address.ShippingAddress;
import com.housely.Model.Card.CreditCard;
import com.housely.Model.Cart.Cart;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Model.Order.CustomerOrder;
import com.housely.Model.Review.Review;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;


    // Relationship
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Review> reviews;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<FavoriteList> favorites;

    @ManyToMany
    @JoinTable(
            name = "customerCreditCard",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "creditCardNumber"))
    private List<CreditCard> creditCards;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrders;

    @OneToOne(mappedBy = "customer")
    private PaymentAddress paymentAddress;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ShippingAddress> shippingAddresses;

    @OneToOne(mappedBy = "customer")
    private Cart cart;


}
