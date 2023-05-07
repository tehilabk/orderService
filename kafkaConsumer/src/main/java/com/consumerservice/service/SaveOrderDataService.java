package com.consumerservice.service;

import com.consumerservice.model.entity.LineItemModel;
import com.consumerservice.model.entity.OrderModel;
import com.consumerservice.model.input.OrderInputModel;
import com.consumerservice.model.output.OrderCreatedModel;
import com.consumerservice.reposirory.LineItemRepository;
import com.consumerservice.reposirory.OrderRepository;
import com.consumerservice.model.entity.UserModel;
import com.consumerservice.reposirory.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SaveOrderDataService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orederRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Autowired
    private OrderCreatedProducer orderCreatedProducer;

    @Autowired
    UserRepository userRepository;



    public void processOrderEvent(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        OrderInputModel orderInput = objectMapper.readValue(consumerRecord.value(), OrderInputModel.class);
        log.info("order consume : {} ", orderInput);
        UserModel user = createNewUserIfNotExist(orderInput.getEmail(),orderInput.getFirstName(),orderInput.getLastName());
        OrderModel orderEntity = new OrderModel(orderInput.getStoreId(),orderInput.getDate(),user.getUserId());
        saveOrder(orderEntity);
        for(LineItemModel lineItem: orderInput.getLineItems()){
           LineItemModel lineItemEntity=new LineItemModel(orderEntity.getOrderId(), lineItem.getProductId(), lineItem.getProductName(),lineItem.getProductDescription(),lineItem.getProductPrice(), lineItem.getQuantity());
           saveItem(lineItemEntity);
        }
        orderCreatedProducer.sendOrderEvent(new OrderCreatedModel(new Date(),orderInput));
    }

    private void saveOrder(OrderModel order) {
        orederRepository.save(order);
        log.info("Successfully Persisted the order{} ", order);
    }
    private void saveItem(LineItemModel item) {
        lineItemRepository.save(item);
        log.info("Successfully Persisted the item {} ", item);
    }

    private UserModel createNewUserIfNotExist(String email, String firstName, String lastName){
        UserModel user;
        List<UserModel> userList= userRepository.findAllByEmailAndFirstNameAndLastName(email,firstName,lastName);
        if (userList.size() == 0){
            user = new UserModel(email,firstName,lastName);
            userRepository.save(user);
        }
        else{
            user = userList.get(0);
        }
        return user;
    }
}


