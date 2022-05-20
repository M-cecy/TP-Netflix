package com.example.microservice3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Microservice3 {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("")
    public void method(){
        ServiceInstance serviceInstance = loadBalancer.choose("Webservice1");
        System.out.println(serviceInstance.getUri());
    }
}
