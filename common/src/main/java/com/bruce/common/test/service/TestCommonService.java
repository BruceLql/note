package com.bruce.common.test.service;

import com.bruce.common.test.common.ExtensionHelper;
import com.bruce.common.test.entity.ReqEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lql
 * @Date 2021/9/26 5:33 下午
 */
@Service
public class TestCommonService {

    @Autowired
    private ExtensionHelper extensionHelper;

    public void test(ReqEntity reqEntity) {
        extensionHelper.updateWithExtension(reqEntity);
    }


}
