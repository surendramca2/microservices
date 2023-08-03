package com.surendra.microservice.cache.controller;


import com.surendra.microservice.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/data/{amount}")
    public String getDataFromCache(@PathVariable int amount){

        ResponseEntity<String> response =cacheService.getDataFromCache(amount);
        return response.toString();
    }
}
