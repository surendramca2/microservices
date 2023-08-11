package com.surendra.microservice.insert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
   private KafkaTemplate<String,String> kafkaTemplate;
    public String makePayment(int amount) throws InterruptedException {
       String str ="";
        if (amount < 2000) {
            str= "Insert service payment request send to server" + amount;
            kafkaTemplate.send("insert_topic",str);
        }
        else{
            Thread.sleep(90000);
            str =" service thread sleeping";
        }
        return str;
    }
}
