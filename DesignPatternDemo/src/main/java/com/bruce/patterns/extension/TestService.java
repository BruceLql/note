package com.bruce.patterns.extension;

import com.bruce.common.extension.ExtensionResult;
import com.bruce.common.extension.execute.DomainWriteExtension;
import com.bruce.common.test.entity.ReqEntity;
import org.springframework.stereotype.Service;

/**
 * @author lql
 * @Date 2021/9/26 6:33 下午
 */
@Service
public class TestService implements DomainWriteExtension {

    @Override
    public ExtensionResult beforeUpdate(ReqEntity reqEntity) {
        System.out.println("---------Override--beforeUpdate------------");

        return DomainWriteExtension.super.beforeUpdate(reqEntity);
    }

    @Override
    public ExtensionResult onUpdate(ReqEntity reqEntity) {
        System.out.println("---------Override--onUpdate------------");
        return DomainWriteExtension.super.onUpdate(reqEntity);
    }
}
