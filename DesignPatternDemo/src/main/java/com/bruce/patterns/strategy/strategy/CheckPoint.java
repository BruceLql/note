package com.bruce.patterns.strategy.strategy;

import org.springframework.stereotype.Component;

/**
 * @author lql
 * @Date 2021/9/24 1:48 下午
 */
@Component
public interface CheckPoint<P, R> {
    /**
     * 检查点
     *
     * @param param 参数
     * @return 返回值
     */
    R doCheck(P param);
}
