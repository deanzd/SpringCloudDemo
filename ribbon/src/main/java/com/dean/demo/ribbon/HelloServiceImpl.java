package com.dean.demo.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService{
    private final RestTemplate restTemplate;

    @Autowired
    public HelloServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sayHello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name="+name,String.class);
    }
}
