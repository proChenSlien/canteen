package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.ContentInfo;
import com.sjto.service.BaseService;
import com.sjto.service.ContentInfoService;
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
 * @Description: 内容说明信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:04
 */
@Api(description = "内容管理")
@RestController
@RequestMapping("/api/content/info")
public class ContentInfoApiController extends BaseController<ContentInfo, Long> {
    @Autowired
    private ContentInfoService contentInfoService;

    @Override
    protected BaseService<ContentInfo, Long> getService() {
        return contentInfoService;
    }

    @ApiOperation("内容管理的详情（APP）")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "String", name = "type", value = "内容类型，格式如2|4，以“|”分割，前部分是字典分组编号后部分是对应字典值。", required = true)})
    @GetMapping("/getOne/{type}")
    public Result getContentInfo(@PathVariable String type) {
        ContentInfo contentInfo = contentInfoService.getByType(type);
        if (contentInfo == null) {
            return Result.createByErrorMessage("内容不存在");
        }
        return Result.createBySuccess(contentInfo);
    }

}
