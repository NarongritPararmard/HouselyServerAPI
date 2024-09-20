package com.housely.Repository;

import com.housely.Model.Cart.CartItem;
import com.housely.Model.Cart.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
}
