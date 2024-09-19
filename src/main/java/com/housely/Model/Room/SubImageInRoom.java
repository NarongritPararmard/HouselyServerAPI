package com.housely.Model.Room;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class SubImageInRoom {
    @Id
    private String subImageId;
    @Column(nullable = false)
    private String subImageBase64;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    @ManyToMany
    @JoinTable(
            name = "productInSubImage",
            joinColumns = @JoinColumn(name = "subImageId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productsInSubImage;


}
