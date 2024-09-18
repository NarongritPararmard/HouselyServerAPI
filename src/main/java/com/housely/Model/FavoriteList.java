package com.housely.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long favoriteListId;
    private String favoriteListName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "favoriteListItem",
            joinColumns = @JoinColumn(name = "favoriteListId"),
            inverseJoinColumns = @JoinColumn(name = "productCode"))
    private List<Product> productInFavoriteList;
}
