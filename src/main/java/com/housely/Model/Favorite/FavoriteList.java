package com.housely.Model.Favorite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteListId;
    private String favoriteListName;


    // Relationship with Customer
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    // Relationship with Product
    @ManyToMany
    @JoinTable(
            name = "favoriteListItem",
            joinColumns = @JoinColumn(name = "favoriteListId"),
            inverseJoinColumns = @JoinColumn(name = "productCode"))
    private List<Product> productInFavoriteList;
}
