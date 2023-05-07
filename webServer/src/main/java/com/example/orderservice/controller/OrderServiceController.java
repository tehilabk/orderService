package com.example.orderservice.controller;

import com.example.orderservice.model.LineItemModel;
import com.example.orderservice.model.OrderModel;
import com.example.orderservice.service.OrderEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<?> createOrder(@PathVariable Long storeId, @Valid @RequestBody OrderModel order) throws JsonProcessingException {
        if (!orderIsValidate(order)) {
            return ResponseEntity.badRequest().build();
        }
        order.setStoreId(storeId);
        orderEventProducer.sendOrderEvent(order);
        return ResponseEntity.ok(order);

    }


    private boolean orderIsValidate(OrderModel order) {
        if (order.getLineItems().size() == 0) {
            return false;
        }
        for (LineItemModel item : order.getLineItems()) {
            if (item.getProductName().equals("") || item.getProductDescription().equals("") ||
                    item.getProductPrice() < 0 || item.getQuantity() < 1) {
                return false;
            }
        }
        return true;
    }


}
