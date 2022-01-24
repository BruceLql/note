package com.bruce.patterns.strategy.strategy.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bruce.patterns.strategy.strategy.Extension;
import com.bruce.patterns.strategy.strategy.entity.Req;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin
 * @date 2021/5/20 17:43
 **/
@RestController
@ResponseBody
@Slf4j
public class TestController {

    private static int count = 0;

    @Autowired
    private Extension extension;

    @SentinelResource(value = "hello")
    @RequestMapping("/hello")
    public String getStrategy(Req req) {
        extension.beforeUpdate(req);
        log.info("==================count: " + count++);
        return "hello";
    }

    @GetMapping("/testSentinel")
    @SentinelResource(value = "testSentinel")
    public @ResponseBody
    String testSentinel() {
        String resourceName = "testSentinel";
        Entry entry = null;
        String retVal;
        try {
            entry = SphU.entry(resourceName, EntryType.IN);
            retVal = "passed";
        } catch (BlockException e) {
            retVal = "blocked";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return retVal;
    }
}
