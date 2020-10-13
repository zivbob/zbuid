package com.ziv.demo;

import com.ziv.pay.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private HelloService helloService;

    @Test
    void contextLoads() {
        helloService.sayHello();
    }

}
