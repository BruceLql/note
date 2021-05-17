package com.bruce;

import com.bruce.aop.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 李启岚(起冉)
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        log.info("==========================");
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        customerService.addCustomer(1234L, "冯宝宝", "一人之下");
        customerService.addCustomer(1234L, "冯宝宝", null);
    }
}
