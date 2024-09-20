package com.housely.Service;

import com.housely.Model.Cart.Cart;
import com.housely.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    // Injecting the CartRepository
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart findById(Long id){
        return cartRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }


}
