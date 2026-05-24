package org.example.session09_b5.controller;

import lombok.RequiredArgsConstructor;
import org.example.session09_b5.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/orderS")
    public String createOrder() {
        orderService.createOrder();
        return "ok";
    }
}
