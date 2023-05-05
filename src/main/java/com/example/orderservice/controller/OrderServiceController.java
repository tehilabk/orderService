package com.example.orderservice.controller;

import com.example.orderservice.model.OrderModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {
    //Todo add validations
    @PostMapping("/{storeId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Long storeId, @RequestBody OrderModel order) {

//        if (order.getDate() == null || order.getEmail() == null || order.getFirstName() == null
//                || order.getLastName() == null || order.getLineItems() == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        for(LineItemModel lineItem : order.getLineItems()){
//            if(lineItem.getId() == null || lineItem.getName() == null || lineItem.getDescription() == null
//                    || lineItem.getPrice() == null || lineItem.getQuantity() == null){
//                return ResponseEntity.badRequest().build();
//            }
//        }

//        StoreModel store = new StoreModel(storeId);
//        order.setStore(store);
//        order = orderRepository.save(order);
//
//        OrderCreatedEvent event = new OrderCreatedEvent(order.getId(), order.getDate(), storeId, order);
//        kafkaTemplate.send("orders.created", event);
//    catch (Exception exception) {
//        exception.printStackTrace();
//        return new ResponseEntity<OrderModel>(order, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
        return ResponseEntity.ok(order);
    }

//    record OrderModel(String date ,String name, String email){}
}
