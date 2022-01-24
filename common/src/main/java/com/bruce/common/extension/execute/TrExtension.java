package com.bruce.common.extension.execute;

import com.bruce.common.extension.ExtensionResult;

/**
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
@FunctionalInterface
public interface TrExtension<T, U, V> {

    /**
     * Applies this extension to the given argument.
     *
     * @param t the first extension argument
     * @param u the second extension argument
     * @param v the third extension argument
     * @return the extension result
     */
    ExtensionResult apply(T t, U u, V v);
}
