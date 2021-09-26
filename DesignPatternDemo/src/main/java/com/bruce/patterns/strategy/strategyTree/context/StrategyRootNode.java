package com.bruce.patterns.strategy.strategyTree.context;

import com.bruce.patterns.strategy.strategyTree.entity.ReqEntity;
import com.bruce.patterns.strategy.strategyTree.entity.ResEntity;
import org.springframework.stereotype.Service;

/**
 * 策略分发的的根节点，需要实现StrategyRouter抽象类
 *
 * @author lin
 * @date 2021/5/20 16:26
 **/
@Service
// extends StrategyRouter<ReqEntity, ResEntity>
public class StrategyRootNode {

    public StrategyRouter.StrategyMapper<ReqEntity, ResEntity> registerStrategyMapper() {
        return null;
    }

}
