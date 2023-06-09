package com.consumerservice.service;

import com.consumerservice.model.output.OrderCreatedModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderCreatedProducer {
    @Value("${kafka.topic.customer}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public void sendOrderEvent(OrderCreatedModel order) throws JsonProcessingException {
        try {
            String value = objectMapper.writeValueAsString(order);
            log.info(String.format("Producing message -> %s", value));
            this.kafkaTemplate.send(topic, value);
        } catch (Exception e) {
            log.info("Failed to Producing message");
        }
    }
}
