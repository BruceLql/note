package com.bruce.patterns.strategy.strategyTree.strategy;

import com.bruce.patterns.strategy.strategyTree.context.StrategyHandler;
import com.bruce.patterns.strategy.strategyTree.context.StrategyRouter;
import com.bruce.patterns.strategy.strategyTree.entity.ReqEntity;
import com.bruce.patterns.strategy.strategyTree.entity.ResEntity;
import org.springframework.stereotype.Service;

/**
 * 策略一
 *
 * @author lin
 * @date 2021/5/20 16:51
 **/
@Service
public class Strategy1 implements StrategyHandler<ReqEntity, ResEntity>, StrategyRouter.StrategyMapper {

    @Override
    public ResEntity approve(ReqEntity param) {
        System.out.println("Strategy1");
        return new ResEntity();
    }

    @Override
    public StrategyHandler get(Object param) {
        return null;
    }
}
