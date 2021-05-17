package com.bruce.aop.service;

import com.bruce.aop.anno.RunTimeLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 李启岚(起冉)
 */
@Slf4j
@Service
public class CustomerService {
    /**
     * 添加收货地址
     */
//    @RunTimeLog
//    public void addCustomer(Long customerId, String userName, String address) {
//        log.info("调用成功addCustomer，当前请求参数customerId={},userName={},address={}", customerId, userName, address);
//    }

    @RunTimeLog
    public void addCustomer(Long customerId, String userName, String address) {
        log.info("调用成功addCustomer，当前请求参数customerId={},userName={},address={}", customerId, userName, address);
        int a = 10 /0;
    }
}
