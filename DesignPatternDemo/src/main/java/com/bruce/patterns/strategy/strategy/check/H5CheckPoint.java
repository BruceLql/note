package com.bruce.patterns.strategy.strategy.check;

import com.bruce.patterns.strategy.strategy.CheckPoint;
import com.bruce.patterns.strategy.strategy.entity.Req;
import com.bruce.patterns.strategy.strategy.entity.Res;
import org.springframework.stereotype.Component;

/**
 * @author lql
 * @Date 2021/9/24 3:04 下午
 */
@Component
public class H5CheckPoint implements CheckPoint<Req, Res> {
    @Override
    public Res doCheck(Req param) {
        System.out.println("-------执行了H5检查点-------");
        return null;
    }
}
