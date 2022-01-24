package com.bruce.common.test.common;

import com.bruce.common.extension.AbstractNormalExtensionDeal;
import com.bruce.common.extension.ExtensionResult;
import com.bruce.common.extension.execute.DomainWriteExtension;
import com.bruce.common.test.entity.ReqEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * @author lql
 * @Date 2021/9/26 5:52 下午
 */
@Slf4j
@Component
public class ExtensionHelper extends AbstractNormalExtensionDeal {

    @Autowired(required = false)
    private DomainWriteExtension domainWriteExtension;


    public void updateWithExtension(ReqEntity reqEntity) {
        // beforeUpdateExtension
        beforeUpdateExtension(reqEntity);
        System.out.println("========== doSomeThing =================");
        // onUpdateExtension
        onUpdateExtension(reqEntity);
    }

    private void beforeUpdateExtension(ReqEntity reqEntity) {
        if (domainWriteExtension == null) {
            return;
        }
        invokeExtension(domainWriteExtension::beforeUpdate, reqEntity);
    }

    private void onUpdateExtension(ReqEntity reqEntity) {
        if (domainWriteExtension == null) {
            return;
        }
        invokeExtension(domainWriteExtension::onUpdate, reqEntity);
    }

    private void beforeCreateExtension(ReqEntity bo) {
        if (domainWriteExtension == null) {
            return;
        }

        StopWatch stopWatch = prepare();
        ExtensionResult extensionResult = domainWriteExtension.beforeCreate(bo);
        finish(stopWatch, extensionResult);
    }

    private void onCreateExtension(ReqEntity bo) {
        if (domainWriteExtension == null) {
            return;
        }

        StopWatch stopWatch = prepare();
        ExtensionResult extensionResult = domainWriteExtension.onCreate(bo);
        finish(stopWatch, extensionResult);
    }
}
