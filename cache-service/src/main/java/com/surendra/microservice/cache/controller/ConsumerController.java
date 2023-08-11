package com.surendra.microservice.cache.controller;

import com.surendra.microservice.cache.service.CacheService;
import com.surendra.microservice.cache.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consume/{amount}")
    public String getConsumeMessage(@PathVariable int amount){

        return consumerService.getConsumeMessage();
    }
}
