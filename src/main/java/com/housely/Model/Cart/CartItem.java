package com.housely.Model.Cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @JsonBackReference
    @ManyToOne
    @MapsId("productCode")
    @JoinColumn(name = "product_code")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(nullable = false)
    private Long quantity;


}
