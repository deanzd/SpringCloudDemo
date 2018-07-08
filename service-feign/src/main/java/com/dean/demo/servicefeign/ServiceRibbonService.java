package com.dean.demo.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-ribbon")
@Service
public interface ServiceRibbonService {
    @RequestMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}
