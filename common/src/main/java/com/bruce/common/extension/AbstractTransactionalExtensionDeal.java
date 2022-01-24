package com.bruce.common.extension;

import com.bruce.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * 事务下的扩展处理结果
 * Code: TER = Transactional Execute Error
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
@Slf4j
public abstract class AbstractTransactionalExtensionDeal extends AbstractExtensionDeal {

    @Override
    public boolean digestion(ExtensionResult result) {
        if (super.digestion(result)) {
            return true;
        }

        if (!result.isSuccess()) {
            log.error("[TER] Transactional Execute fail with deadly: {}, message: {}", result.isDeadly(), result.getMessage());
            throw new ServiceException("[事务]扩展执行失败");
        }

        return false;
    }
}
