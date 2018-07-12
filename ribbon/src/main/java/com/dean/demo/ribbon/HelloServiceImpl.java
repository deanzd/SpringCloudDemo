package com.dean.demo.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {
    private final RestTemplate restTemplate;

    @Autowired
    public HelloServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "sayHelloError")
    public String sayHello(String name) {
        String result = restTemplate.getForObject("http://service-eureka/hello?name=" + name, String.class);
        return result + ", from ribbon";
    }

    public String sayHelloError(String name) {
        return "say hello error, name = " + name;
    }
}
