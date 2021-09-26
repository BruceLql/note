package com.bruce.patterns.strategy.strategy.controller;

import com.bruce.patterns.strategy.strategy.Extension;
import com.bruce.patterns.strategy.strategy.entity.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin
 * @date 2021/5/20 17:43
 **/
@RestController
@ResponseBody
public class TestController {

    @Autowired
    private Extension extension;

    @RequestMapping("/hello")
    public String getStrategy(Req req) {
        extension.beforeUpdate(req);
        return "hello";
    }
}
