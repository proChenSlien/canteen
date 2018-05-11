package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.ContentInfo;
import com.sjto.service.BaseService;
import com.sjto.service.ContentInfoService;
import com.sjto.utils.Result;
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
    @GetMapping("/getOne/{type}")
    public Result getContentInfo(@PathVariable String type) {
        ContentInfo contentInfo = contentInfoService.getByType(type);
        if (contentInfo == null) {
            return Result.createByErrorMessage("内容不存在");
        }
        return Result.createBySuccess(contentInfo);
    }

}
