package com.dean.demo.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class ServiceEurekaServiceHystrix implements ServiceEurekaService{
    @Override
    public String sayHello(String name) {
        return "Say hello error, feign, name: " + name;
    }
}
