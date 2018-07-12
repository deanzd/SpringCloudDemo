package com.dean.demo.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-eureka", fallback = ServiceEurekaServiceHystrix.class)
@Service
public interface ServiceEurekaService {
    @RequestMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}
