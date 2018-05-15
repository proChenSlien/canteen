package com.sjto.controller;

import com.sjto.domain.SysDictionaryGroup;
import com.sjto.service.BaseService;
import com.sjto.service.SysDicGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenpeng
 * @Date: 2018/5/15  17:46
 */
@Api(description = "字典组后台请求接口列表")
@RestController
@RequestMapping("/manage/system/sysDictionaryGroup")
public class SysDicGroupController extends BaseController<SysDictionaryGroup, Long>{
    @Autowired
    private SysDicGroupService sysDicGroupService;

    @Override
    protected BaseService<SysDictionaryGroup, Long> getService() {
        return sysDicGroupService;
    }
}
