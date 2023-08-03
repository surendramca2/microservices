package com.surendra.microservice.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CacheService {


    RestTemplate restTemplate;
    String host = "http://localhost:8080/service/payment/";
    public ResponseEntity<String> getDataFromCache(int amount){
        restTemplate = new RestTemplate();
       ResponseEntity<String> response = restTemplate.getForEntity(host+amount,String.class);

       return response;

    }
}
