package com.housely.Model.Cart;

import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(nullable = false)
    private Long quantity;


}
