package com.housely.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cartId")
    private Cart cart;

    @Column(nullable = false)
    private Long quantity;


}
