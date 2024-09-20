package com.housely.Controller;

import com.housely.Model.Cart.Cart;
import com.housely.Model.Customer.Customer;
import com.housely.Serevice.CartItemService;
import com.housely.Serevice.CartService;
import com.housely.Serevice.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private final CartService cartService;
    private final CustomerService  customerService;
    private final CartItemService cartItemService;

    public CartController(CartService cartService, CartItemService cartItemService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.cartItemService = cartItemService;
    }


    @GetMapping("/customer/{id}/cart")
    public @ResponseBody Cart getCartByCustomerId(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return customer.getCart();
    }

    @PostMapping("/customer/{id}/cart")
    public @ResponseBody Cart addCart(@RequestBody Cart cart, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        cart.setCustomer(customer);
        return cartService.save(cart);
    }

//    @PutMapping("/customer/{id}/cart/{cartId}")

}
