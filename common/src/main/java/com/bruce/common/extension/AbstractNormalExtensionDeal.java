package com.bruce.common.extension;

import com.bruce.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * 非事务下的扩展执行结果处理
 * Code: EEW = Extension Execute Warn
 * Code: EER = Extension Execute Error
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
@Slf4j
public abstract class AbstractNormalExtensionDeal extends AbstractExtensionDeal {

    @Override
    public boolean digestion(ExtensionResult result) {
        if (super.digestion(result)) {
            return true;
        }

        if (result.isDeadly()) {
            log.error("[EER] Extension execute deadly fail, cause: {}", result.getMessage());
            throw new ServiceException(result.getMessage());
        }

        log.warn("[EEW] Extension execute fail, cause: {}", result.getMessage());

        return true;
    }
}
