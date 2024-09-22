package com.housely.Controller;

import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
import com.housely.Model.Order.OrderItem;
import com.housely.Model.Order.OrderItemKey;
import com.housely.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.housely.Service.CustomerOrderService;
import com.housely.Service.OrderItemService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class OrderController {
    private final CustomerOrderService customerOrderService;
    private final OrderItemService orderItemService;
    private final CustomerService customerService;

    public OrderController(CustomerOrderService customerOrderService, OrderItemService orderItemService, CustomerService customerService) {
        this.customerOrderService = customerOrderService;
        this.orderItemService = orderItemService;
        this.customerService = customerService;
    }


    @GetMapping("/customer/{cusId}/customer-orders")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable Long cusId) {
        try{
            customerService.findById(cusId);
            List<CustomerOrder> customerOrders = customerOrderService.findCustomerOrdersByCustomerId(cusId);
            return new ResponseEntity<>(customerOrders, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{cusId}/customer-orders/{orderId}")
    public ResponseEntity<?> getCustomerOrderById(@PathVariable Long cusId, @PathVariable Long orderId) {
        try{
            customerService.findById(cusId);
            return new ResponseEntity<>(
                    customerOrderService.findCustomerOrderByCustomerAndOrderId(cusId, orderId),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{cusId}/customer-orders/{orderId}/order-items")
    public ResponseEntity<?> getOrderItems(@PathVariable Long cusId, @PathVariable Long orderId) {
        try{
            customerService.findById(cusId);
            customerOrderService.findById(orderId);
            return new ResponseEntity<>(orderItemService.findByCustomerAndOrder(cusId, orderId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{cusId}/customer-orders/{orderId}/order-items/{itemId}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long cusId, @PathVariable Long orderId, @PathVariable OrderItemKey itemId) {
        try{
            customerService.findById(cusId);
            customerOrderService.findById(orderId);
            return new ResponseEntity<>(orderItemService.findByCustomerAndOrder(cusId, orderId, itemId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customer/{cusId}/customer-orders")
    public ResponseEntity<?> createOrder(@PathVariable Long cusId, @RequestBody CustomerOrder customerOrder) {
        try{
            Customer customer = customerService.findById(cusId);
            customerOrder.setCustomer(customer);
            return new ResponseEntity<>(customerOrderService.save(customerOrder), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/customer/{cusId}/customer-orders/{orderId}/order-items")
    public ResponseEntity<?> createOrderItem(@PathVariable Long cusId, @PathVariable Long orderId, @RequestBody OrderItem orderItem) {
        try{
            customerService.findById(cusId);
            CustomerOrder customerOrder = customerOrderService.findCustomerOrderByCustomerAndOrderId(cusId, orderId);
            orderItem.setCustomerOrder(customerOrder);
            return new ResponseEntity<>(orderItemService.save(orderItem), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/customer/{cusId}/customer-orders/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Long cusId, @PathVariable Long orderId, @RequestBody CustomerOrder customerOrder) {
        try{
            customerOrder.setCustomer(customerService.findById(cusId));
            customerOrder.setOrderId(customerOrderService.findById(orderId).getOrderId());
            return new ResponseEntity<>(customerOrderService.save(customerOrder), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/customer/{cusId}/customer-orders/{orderId}/order-items/{itemId}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long cusId, @PathVariable Long orderId, @PathVariable OrderItemKey itemId, @RequestBody OrderItem orderItem) {
        try{
            customerService.findById(cusId);
            orderItem.setCustomerOrder(customerOrderService.findCustomerOrderByCustomerAndOrderId(cusId, orderId));
            orderItem.setOrderItemId(itemId);
            return new ResponseEntity<>(orderItemService.save(orderItem), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/customer/{cusId}/customer-orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long cusId, @PathVariable Long orderId) {
        try{
            customerService.findById(cusId);
            customerOrderService.deleteById(orderId);
            return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/customer/{cusId}/customer-orders/{orderId}/order-items/{itemId}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long cusId, @PathVariable Long orderId, @PathVariable OrderItemKey itemId) {
        try{
            customerService.findById(cusId);
            customerOrderService.findById(orderId);
            orderItemService.findById(itemId);
            orderItemService.deleteById(itemId);
            return new ResponseEntity<>("Order item deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




    @GetMapping("/customer-orders/all")
    public ResponseEntity<?> getAllOrders() {
        try{
            return new ResponseEntity<>(customerOrderService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/customer-orders/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        try{
            return new ResponseEntity<>(customerOrderService.findById(orderId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer-orders/{orderId}/order-items")
    public ResponseEntity<?> getOrderItems(@PathVariable Long orderId) {
        try{
            customerOrderService.findById(orderId);
            return new ResponseEntity<>(orderItemService.findByOrderId(orderId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer-orders/{orderId}/order-items/{itemId}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long orderId, @PathVariable OrderItemKey itemId) {
        try{
            customerOrderService.findById(orderId);
            return new ResponseEntity<>(orderItemService.findById(itemId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}