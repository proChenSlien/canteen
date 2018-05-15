package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.SysButtonInfo;
import com.sjto.service.BaseService;
import com.sjto.service.SysButtonInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 按钮信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 13:36
 */
@Api(description = "按钮信息")
@RestController
@RequestMapping("/api/system/button")
public class SysButtonInfoApiController extends BaseController<SysButtonInfo, Long> {
    @Autowired
    private SysButtonInfoService sysButtonInfoService;

    @Override
    protected BaseService<SysButtonInfo, Long> getService() {
        return sysButtonInfoService;
    }

    @ApiOperation("按钮配置信息的查询（APP）")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "String", name = "type", value = "按钮类型,格式如2|4，以“|”分割，前部分是字典分组编号后部分是对应字典值。", required = true)})
    @GetMapping("/getOne/{type}")
    public Result getContentInfo(@PathVariable String type) {
        SysButtonInfo sysButtonInfo = sysButtonInfoService.getOneByType(type);
        if (sysButtonInfo == null) {
            return Result.createByErrorMessage("内容不存在");
        }
        return Result.createBySuccess(sysButtonInfo);
    }
}
