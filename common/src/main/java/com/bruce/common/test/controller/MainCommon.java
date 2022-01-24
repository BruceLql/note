package com.bruce.common.test.controller;

import com.bruce.common.test.entity.ReqEntity;
import com.bruce.common.test.service.TestCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lql
 * @date 2021/9/26 5:12 下午
 **/
@RestController
@ResponseBody
public class MainCommon {
    @Autowired
    private TestCommonService testCommonService;

    @RequestMapping("/helloCommon")
    public String hello(ReqEntity reqEntity) {
        testCommonService.test(reqEntity);
        return "hello";
    }

}
