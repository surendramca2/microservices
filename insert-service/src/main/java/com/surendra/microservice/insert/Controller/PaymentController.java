package com.surendra.microservice.insert.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.surendra.microservice.insert.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.RuntimeMBeanException;

@RestController
@RequestMapping("/service")
public class PaymentController {

    @Autowired
private PaymentService paymentService;
    @GetMapping("/payment/{amount}")
    @HystrixCommand(fallbackMethod = "failureMethod",commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",
            value="6"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",
            value = "5000"),
            @HystrixProperty(name= "circuitBreaker.enabled",
            value="false")
    })
    public String makePayment(@PathVariable int amount) throws InterruptedException {
       return paymentService.makePayment(amount);
       /* if(amount>2000){
            throw new RuntimeException("Amount exceeded");
        }
        System.out.println("payment successful");
        return "payment done";*/
    }

    public String failureMethod(int amount){

        return "payment failed, failure method for "+amount;
    }

}
