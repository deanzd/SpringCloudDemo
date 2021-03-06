package com.dean.demo.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String name) {
        return helloService.sayHello(name);
    }

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

}
