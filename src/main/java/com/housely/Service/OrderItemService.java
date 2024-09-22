package com.housely.Service;

import com.housely.Model.Order.OrderItem;
import com.housely.Model.Order.OrderItemKey;
import com.housely.Repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem findById(OrderItemKey id) {
        return orderItemRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("OrderItem not found"));
    }

    public OrderItem findByCustomerAndOrder(Long cusId, Long orderId, OrderItemKey itemId) {
        return orderItemRepository.findOrderItemByCustomerAndOrder(cusId, orderId, itemId)
                .orElseThrow(
                        () -> new RuntimeException("OrderItem not found"));
    }

    public List<OrderItem> findByCustomerAndOrder(Long cusId, Long orderId) {
        return orderItemRepository.findOrderItemsByCustomerAndOrder(cusId, orderId);
    }

    public List<OrderItem> findByOrderId(Long orderId) {
        return orderItemRepository.findOrderItemsByOrderId(orderId);
    }

    public void deleteById(OrderItemKey id) {
        orderItemRepository.deleteById(id);
    }
}
