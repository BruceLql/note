package com.bruce.patterns.strategy.strategy;

import com.bruce.patterns.strategy.strategy.entity.Req;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lql
 * @Date 2021/9/24 2:49 下午
 */
@Component
@RequiredArgsConstructor
public class Extension {
    @Resource
    private List<CheckPoint> itemCheckPoint;

    public void beforeUpdate(Req req) {
        // 遍历执行检查点
        itemCheckPoint.forEach(point -> {
            System.out.println("=============:" + point.toString());
            point.doCheck(req);
        });
    }

}
