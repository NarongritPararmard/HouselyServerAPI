package com.housely.Controller;

import com.housely.Model.Cart.Cart;
import com.housely.Model.Cart.CartItem;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
import com.housely.Service.CartItemService;
import com.housely.Service.CartService;
import com.housely.Service.CustomerOrderService;
import com.housely.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private final CartService cartService;
    private final CustomerService  customerService;
    private final CartItemService cartItemService;
    @Autowired
    private CustomerOrderService customerOrderService;

    public CartController(CartService cartService, CartItemService cartItemService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.cartItemService = cartItemService;
    }


    @GetMapping("/customer/{id}/cart/{cartId}")
    public @ResponseBody Cart getCartByCustomerId(@PathVariable Long id, @PathVariable Long cartId) {
        Customer customer = customerService.findById(id);
        customer.setCart(cartService.findById(cartId));
        return customer.getCart();
    }

    @GetMapping("/customer/{id}/cart/{cartId}/cart-item")
    public @ResponseBody List<CartItem> getCartItemByCartId(@PathVariable Long id, @PathVariable Long cartId) {
        Customer customer = customerService.findById(id);
        customer.setCart(cartService.findById(cartId));
        return customer.getCart().getCartItems();
    }



    @PostMapping("/customer/{id}/cart")
    public @ResponseBody Cart addCart(@RequestBody Cart cart, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        cart.setCustomer(customer);
        return cartService.save(cart);
    }

    @PutMapping("/customer/{id}/cart/{cartId}")
    public @ResponseBody Cart updateCart(@RequestBody Cart cart, @PathVariable Long id, @PathVariable Long cartId) {
        Customer customer = customerService.findById(id);
        cart.setCartId(cartId);
        cart.setCustomer(customer);
        return cartService.save(cart);
    }

    @DeleteMapping("/customer/{id}/cart/{cartId}")
    public @ResponseBody String deleteCart(@PathVariable Long id, @PathVariable Long cartId) {
        Customer customer = customerService.findById(id);
        Cart cart = cartService.findById(cartId);
        if (cart != null && cart.getCustomer().equals(customer)) {
            cartService.deleteById(cartId);
        }
        return String.format("Cart Id:%d was delete successfully!", cartId);
    }

    @GetMapping("/customer/{id}")
    public @ResponseBody CustomerOrder test(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return customer.getCustomerOrders().getFirst();
    }



}
