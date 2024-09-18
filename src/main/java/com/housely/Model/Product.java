package com.housely.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productCode ;

    @Column(nullable = false)
    private String brandName ;

    @Column(nullable = false)
    private String productName ;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity ;

    @Column(nullable = false)
    private String imageBase64;

    @Column(nullable = false)
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    @ManyToMany(mappedBy = "productInRooms")
    private List<Room> rooms;

    @ManyToMany(mappedBy = "productInCategories")
    private List<Category> categories;

    @ManyToMany(mappedBy = "productInFavoriteList")
    private List<FavoriteList> favoriteLists;

    @ManyToMany(mappedBy = "productsOrdered")
    private List<Order> orders;

}
