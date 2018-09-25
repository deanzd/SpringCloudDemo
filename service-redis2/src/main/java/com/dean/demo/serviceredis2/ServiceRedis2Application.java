package com.dean.demo.serviceredis2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/str")
public class ServiceRedis2Application {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceRedis2Application.class, args);
    }

    @RequestMapping("/set")
    public void set(@RequestParam(value = "key", required = true) String key,
                    @RequestParam(value = "value", required = true) String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/get")
    public String get(@RequestParam(value = "key", required = true) String key) {
        stringRedisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                System.out.println(1);
                return 1;
            }
        });
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println(2);
        return s;
    }
}
