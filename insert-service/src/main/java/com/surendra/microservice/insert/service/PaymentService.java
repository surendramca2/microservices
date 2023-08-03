package com.surendra.microservice.insert.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String makePayment(int amount) throws InterruptedException {
       String str ="";
        if (amount < 2000) {
            str= "service done from service";
        }
        else{
            Thread.sleep(90000);
            str =" service thread sleeping";
        }
        return str;
    }
}
