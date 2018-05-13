package com.sjto.controller;

import com.sjto.domain.SysButtonInfo;
import com.sjto.service.BaseService;
import com.sjto.service.SysButtonInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 按钮信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:39
 */
@RestController
@RequestMapping("/manage/system/button")
public class SysButtonInfoController extends BaseController<SysButtonInfo, Long> {
    @Autowired
    private SysButtonInfoService sysButtonInfoService;

    @Override
    protected BaseService<SysButtonInfo, Long> getService() {
        return sysButtonInfoService;
    }

    @Override
    @ApiOperation("添加或更新")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute SysButtonInfo entity) {
        Result result = Result.createBySuccess();
        //会员充值套餐是否已存在
        boolean isExist = sysButtonInfoService.isExist(entity);
        if (isExist) {
            result = Result.createByErrorMessage("该按钮已存在");
        } else {
            //保存
            result = super.saveOrUpdate(entity);
        }
        return result;
    }

}
