package com.housely.Service;

import com.housely.Model.Cart.CartItem;
import com.housely.Repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService{
    private final CartItemRepository cartItemRepository;

    // Injecting the CartItemRepository
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> findAll(){
        return cartItemRepository.findAll();
    }

    public CartItem save(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public CartItem findById(Long id){
        return cartItemRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        cartItemRepository.deleteById(id);
    }

    public void deleteAll(){
        cartItemRepository.deleteAll();
    }

}
