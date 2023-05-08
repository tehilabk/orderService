package com.orderservice.controller;

import com.orderservice.model.OrderModel;
import com.orderservice.service.OrderEventProducer;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class OrderServiceController {

    @Autowired
    OrderEventProducer orderEventProducer;

    @PostMapping("/{storeId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Long storeId, @Valid @RequestBody OrderModel order) {

        if (!orderIsValid(order)) {
            return ResponseEntity.badRequest().build();
        }
        order.setStoreId(storeId);
        try {
            orderEventProducer.sendOrderEvent(order);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(order);
    }

    private boolean orderIsValid(OrderModel order) {
        return order.isValid();
    }
}
