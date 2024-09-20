package com.housely.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.housely.Serevice.CustomerOrderService;
import com.housely.Serevice.OrderItemService;

@RestController
@RequestMapping("/api/customer/{id}")
public class OrderController {
    private final CustomerOrderService custOrderService;
    private final OrderItemService orderItemService;

    

}