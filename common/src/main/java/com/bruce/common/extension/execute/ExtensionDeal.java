package com.bruce.common.extension.execute;

import com.bruce.common.extension.ExtensionResult;

/**
 * 处理扩展结果，内部用
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
public interface ExtensionDeal {

    /**
     * 处理扩展结果
     *
     * @param result 处理结果
     * @return 处理是否完成
     */
    boolean digestion(ExtensionResult result);
}
