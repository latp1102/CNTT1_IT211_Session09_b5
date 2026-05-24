package org.example.session09_b5.Service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void createOrder() {
        throw new RuntimeException("Mất kết nối database");
    }
}
