package com.dean.demo.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RestController
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }

    private ServiceRibbonService serviceRibbonService;

    private ServiceEurekaService serviceEurekaService;

    @Autowired
    public ServiceFeignApplication(ServiceRibbonService serviceRibbonService, ServiceEurekaService serviceEurekaService) {
        this.serviceRibbonService = serviceRibbonService;
        this.serviceEurekaService = serviceEurekaService;
    }

    @RequestMapping("/hello")
    public  String sayHelloEureka(@RequestParam("name") String name) {
       return serviceEurekaService.sayHello(name) + ", from feign";
    }

    @RequestMapping("/hello-ribbon")
    public  String sayHelloRibbon(@RequestParam(name = "name") String name) {
        return serviceRibbonService.sayHello(name) + ", from feign";
    }
}
