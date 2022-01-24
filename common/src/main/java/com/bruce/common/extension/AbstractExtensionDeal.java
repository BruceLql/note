package com.bruce.common.extension;

import com.bruce.common.exception.ServiceException;
import com.bruce.common.extension.execute.BiExtension;
import com.bruce.common.extension.execute.Extension;
import com.bruce.common.extension.execute.ExtensionDeal;
import com.bruce.common.extension.execute.TrExtension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * {@link ExtensionDeal}的简单扩展，实现了对内部定义ExtensionResult({@link ExtensionResult})的解析和处理。
 * 同时针对扩展接口的耗时
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
@Slf4j
public abstract class AbstractExtensionDeal implements ExtensionDeal {

    @Override
    public boolean digestion(ExtensionResult result) {
        if (result == null) {
            throw new IllegalArgumentException("扩展执行结果不可返回空");
        }

        // 内部定义，认定其不生效
        if (result.isInternal()) {
            return true;
        }

        if (result.isSuccess()) {
            return true;
        }

        // 非内部定义，且未成功，派生类处理
        return false;
    }

    /**
     * 准备开启性能检测<br>
     * <p>
     * 结束调用{@link #finishMonitor(StopWatch)} )}方法
     * </p>
     * 仅在Debug开启的情况下生效
     *
     * @return StopWatch对象
     */
    private StopWatch prepareMonitor() {
        if (!log.isDebugEnabled()) {
            return null;
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        return stopWatch;
    }

    /**
     * 性能检测结束<br>
     * 仅在Debug开启的情况下生效
     *
     * @param stopWatch 方法{@link #prepareMonitor()}提供的StopWatch对象
     * @see #prepareMonitor()
     */
    private void finishMonitor(StopWatch stopWatch) {
        if (!log.isDebugEnabled()) {
            return;
        }

        if (stopWatch == null) {
            throw new RuntimeException("Debug日志下stopWatch对象不应该为空，请先调用prepareMonitor方法");
        }

        stopWatch.stop();

        log.debug("[耗时监测] 扩展调用耗时: {}毫秒", stopWatch.getTotalTimeMillis());
    }


    /**
     * 扩展调用前置准备<br>
     * 在开启debug时，将打印接口调用耗时
     *
     * @return StopWatch对象
     * @see #finish(StopWatch, ExtensionResult)
     */
    protected StopWatch prepare() {
        return prepareMonitor();
    }

    /**
     * 扩展调用结束处理<br>
     * 在开启debug时，将打印接口调用耗时
     *
     * @param stopWatch       StopWatch对象
     * @param extensionResult 扩展执行结果
     * @see #prepare()
     * @see #prepareMonitor()
     */
    protected void finish(StopWatch stopWatch, ExtensionResult extensionResult) {
        finishMonitor(stopWatch);
        digestion(extensionResult);
    }


    /**
     * 封装的扩展调用工具
     *
     * @param extension 扩展方法实例
     * @param param     附加参数
     * @param <T>       参数类型
     */
    protected <T> void invokeExtension(Extension<T> extension, T param) {
        StopWatch stopWatch = prepareMonitor();
        try {
            ExtensionResult result = extension.apply(param);
            digestion(result);
        } catch (Exception e) {
            log.error("An error catch by extension invoker of: {}, which is forbidden!", extension);
            throw new ServiceException(e.getMessage());
        } finally {
            finishMonitor(stopWatch);
        }
    }

    /**
     * 封装的扩展调用工具
     *
     * @param extension 扩展方法实例
     * @param t         附加参数1
     * @param u         附加参数2
     * @param <T>       参数1类型
     * @param <U>       参数2类型
     */
    protected <T, U> void invokeExtension(BiExtension<T, U> extension, T t, U u) {
        StopWatch stopWatch = prepareMonitor();
        try {
            ExtensionResult result = extension.apply(t, u);
            digestion(result);
        } catch (Exception e) {
            log.error("An error catch by extension invoker of: {}, which is forbidden!", extension);
            throw new ServiceException(e.getMessage());
        } finally {
            finishMonitor(stopWatch);
        }
    }

    /**
     * 封装的扩展调用工具
     *
     * @param extension 扩展方法实例
     * @param t         附加参数1
     * @param u         附加参数2
     * @param v         附加参数3
     * @param <T>       参数1类型
     * @param <U>       参数2类型
     * @param <V>       参数3类型
     */
    protected <T, U, V> void invokeExtension(TrExtension<T, U, V> extension, T t, U u, V v) {
        StopWatch stopWatch = prepareMonitor();
        try {
            ExtensionResult result = extension.apply(t, u, v);
            digestion(result);
        } catch (Exception e) {
            log.error("An error catch by extension invoker of: {}, which is forbidden!", extension);
            throw new ServiceException(e.getMessage());
        } finally {
            finishMonitor(stopWatch);
        }
    }
}
