package com.example.consumerservice.service;

import com.example.consumerservice.model.OrderModel;
import com.example.consumerservice.reposirory.OrederRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class SaveOrderDataService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private OrederRepository orederRepository;

    public void processOrderEvent(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        OrderModel order = objectMapper.readValue(consumerRecord.value(), OrderModel.class);
        log.info("order consume : {} ", order);
        save(order);
    }

    private void save(OrderModel order) {
        orederRepository.save(order);
        log.info("Successfully Persisted the order Event {} ", order);
    }
}


