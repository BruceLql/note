package com.bruce.patterns.strategy.strategyTree.controller;

import com.bruce.patterns.strategy.strategyTree.context.StrategyRootNode;
import com.bruce.patterns.strategy.strategyTree.entity.ReqEntity;
import com.bruce.patterns.strategy.strategyTree.entity.ResEntity;
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
public class Main {

    @Autowired
    private StrategyRootNode strategyRootNode;

    @RequestMapping("/getStrategy")
    public ResEntity getStrategy(ReqEntity reqEntity) {
        return null;
    }

}
