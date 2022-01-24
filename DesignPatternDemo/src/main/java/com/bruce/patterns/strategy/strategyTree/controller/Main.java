package com.bruce.patterns.strategy.strategyTree.controller;

import com.bruce.common.test.common.ExtensionHelper;
import com.bruce.patterns.strategy.strategyTree.context.StrategyRootNode;
import com.bruce.patterns.strategy.strategyTree.entity.ReqEntity;
import com.bruce.patterns.strategy.strategyTree.entity.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lin
 * @date 2021/5/20 17:43
 **/
@RestController
@ResponseBody
public class Main {

    @Autowired
    private StrategyRootNode strategyRootNode;

    @Resource
    private ExtensionHelper extensionHelper;

    @RequestMapping("/getStrategy")
    public ResEntity getStrategy(ReqEntity reqEntity) {
        return null;
    }


    @RequestMapping("/hi")
    public String hi(com.bruce.common.test.entity.ReqEntity reqEntity) {

        extensionHelper.updateWithExtension(reqEntity);
        return "hi";
    }
}
