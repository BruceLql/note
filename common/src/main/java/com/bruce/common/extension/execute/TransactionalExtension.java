package com.bruce.common.extension.execute;

import com.bruce.common.extension.ExtensionResult;

/**
 * 商品事务扩展<br>
 * <p>
 * 注意！扩展方法内禁止调用RPC，原则上需要避免使用SQL读方法！
 * </p>
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
public interface TransactionalExtension {

    /**
     * 商品创建事务内扩展 - 前置<br>
     * 匹配的后置扩展为：
     *
     * @param bo 创建操作对象
     * @return 扩展处理结果
     */
    default ExtensionResult beforeCreate(Object bo) {
        return ExtensionResult.internal();
    }

    /**
     * 商品创建事务内扩展
     *
     * @param bo 创建操作对象
     * @return 扩展处理结果
     */
    default ExtensionResult onCreate(Object bo) {
        return ExtensionResult.internal();
    }

    /**
     * 商品更新事务内扩展 - 前置<br>
     * 匹配的后置扩展为:
     *
     * @param bo 更新操作对象
     * @return 扩展处理结果
     */
    default ExtensionResult beforeUpdate(Object bo) {
        return ExtensionResult.internal();
    }

    /**
     * 商品更新事务内扩展
     *
     * @param bo 更新操作对象
     * @return 扩展处理结果
     */
    default ExtensionResult onUpdate(Object bo) {
        return ExtensionResult.internal();
    }
}
