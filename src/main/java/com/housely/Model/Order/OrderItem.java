package com.housely.Model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @EmbeddedId
    private OrderItemKey orderItemId;
    private int quantity;


    // Relationship with CustomerOrder
    @JsonBackReference
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    // Relationship with Product
    @JsonBackReference
    @ManyToOne
    @MapsId("productCode")
    @JoinColumn(name = "product_code")
    private Product product;

}
