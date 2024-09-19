package com.housely.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SubImageInRoom {
    @Id
    private String subImageId;
}
