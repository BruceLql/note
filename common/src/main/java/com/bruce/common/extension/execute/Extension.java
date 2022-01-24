package com.bruce.common.extension.execute;

import com.bruce.common.extension.ExtensionResult;

/**
 * @author lql
 * @Date 2021/9/26 5:12 下午
 */
@FunctionalInterface
public interface Extension<T> {

    /**
     * Applies this extension to the given argument.
     *
     * @param t the extension argument
     * @return the extension result
     */
    ExtensionResult apply(T t);
}
