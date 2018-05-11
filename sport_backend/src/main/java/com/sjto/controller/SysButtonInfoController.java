package com.sjto.controller;

import com.sjto.domain.SysButtonInfo;
import com.sjto.service.BaseService;
import com.sjto.service.SysButtonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 按钮信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:39
 */
@RestController
@RequestMapping("/api/system/button")
public class SysButtonInfoController extends BaseController<SysButtonInfo, Long> {
    @Autowired
    private SysButtonInfoService sysButtonInfoService;

    @Override
    protected BaseService<SysButtonInfo, Long> getService() {
        return sysButtonInfoService;
    }
}
