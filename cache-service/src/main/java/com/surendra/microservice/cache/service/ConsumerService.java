package com.surendra.microservice.cache.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private String consumeMessage ="";
    @KafkaListener(topics = "insert-topic",group ="group-id")
public void consume(String message){
        consumeMessage = message;
        System.out.println("consumer service consumed !!"+ message);
    }

    public String getConsumeMessage(){

        return consumeMessage;
    }
}
