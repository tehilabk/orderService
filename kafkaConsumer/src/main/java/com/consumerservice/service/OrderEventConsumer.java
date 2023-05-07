package com.consumerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderEventConsumer {

    @Autowired
    SaveOrderDataService saveOrderDataService;

    @KafkaListener(topics = {"order-event-topic"})
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {

        log.info("ConsumerRecord : {} ", consumerRecord);
        saveOrderDataService.processOrderEvent(consumerRecord);

    }

}
