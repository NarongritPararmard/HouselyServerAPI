package com.housely.Model.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Cart.CartItem;
import com.housely.Model.Category.Category;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Model.Order.OrderItem;
import com.housely.Model.Review.Review;
import com.housely.Model.Room.Room;
import com.housely.Model.Room.SubImageInRoom;
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


    // Relationship with Review
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    // Relationship with Room
    @ManyToMany(mappedBy = "productInRooms")
    private List<Room> rooms;

    // Relationship with Category
    @ManyToMany(mappedBy = "productInCategories")
    private List<Category> categories;

    // Relationship with FavoriteList
    @ManyToMany(mappedBy = "productInFavoriteList")
    private List<FavoriteList> favoriteLists;

    // Relationship with CartItem
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    // Relationship with OrderItem
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    // Relationship with SubImageInRoom
    @ManyToMany(mappedBy = "productsInSubImage")
    private List<SubImageInRoom> subImageInRooms;

}
