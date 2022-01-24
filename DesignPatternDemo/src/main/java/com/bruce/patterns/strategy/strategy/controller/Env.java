package com.bruce.patterns.strategy.strategy.controller;

import com.alibaba.csp.sentinel.CtSph;
import com.alibaba.csp.sentinel.Sph;
import com.alibaba.csp.sentinel.init.InitExecutor;

/**
 * @author lql
 * @Date 2021/11/25 10:20 上午
 */
public class Env {
    public static final Sph sph = new CtSph();

    static {
        // If init fails, the process will exit.
        InitExecutor.doInit();
    }
}