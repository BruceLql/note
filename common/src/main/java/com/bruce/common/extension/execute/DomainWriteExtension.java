package com.bruce.common.extension.execute;


import com.bruce.common.extension.ExtensionResult;
import com.bruce.common.test.entity.ReqEntity;

/**
 * 商品域内写扩展。
 * <p>
 * 域内写扩展是在发生数据库写入操作前的逻辑处理过程的最后。其包括创建和更新两个环节：<br>
 * 1. 创建环节参见 <br>
 * 2. 更新环节参见 <br>
 * 以上两个环节都属于数据准备阶段，不会产生实际的数据库写操作。
 * </p>
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
public interface DomainWriteExtension {

    /**
     * 创建扩展（非事务）- 前置<br>
     * 匹配的后置方法为：
     *
     * @return 扩展处理结果
     */
    default ExtensionResult beforeCreate(ReqEntity reqEntity) {
        return ExtensionResult.internal();
    }

    /**
     * 商品域内创建扩展（非事务）
     *
     * @return 扩展处理结果
     */
    default ExtensionResult onCreate(ReqEntity reqEntity) {
        return ExtensionResult.internal();
    }

    /**
     * 商品域内更新扩展（非事务）- 前置<br>
     * 匹配的后置方法为
     *
     * @return 扩展处理结果
     */
    default ExtensionResult beforeUpdate(ReqEntity reqEntity) {
        return ExtensionResult.internal();
    }


    /**
     * 商品域内更新扩展（非事务）
     *
     * @return 扩展处理结果
     */
    default ExtensionResult onUpdate(ReqEntity reqEntity) {
        return ExtensionResult.internal();
    }
}
