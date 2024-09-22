package com.housely;

import com.housely.Model.Cart.CartItemKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouselyServerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouselyServerApiApplication.class, args);





        CartItemKey id = new CartItemKey((long) 1, "123");
        CartItemKey id2 = new CartItemKey((long) 1, "123");
        CartItemKey id3 = new CartItemKey((long) 2, "123");


        System.out.println("\n\n--------------------- Has code ---------------------");
        System.out.println(id.hashCode());
        System.out.println(id2.hashCode());
        System.out.println(id3.hashCode());
    }

}
