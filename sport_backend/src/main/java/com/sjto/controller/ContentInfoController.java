package com.sjto.controller;

import com.sjto.domain.ContentInfo;
import com.sjto.service.BaseService;
import com.sjto.service.ContentInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 内容说明信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/12 15:12
 */
@RestController
@RequestMapping("/manage/content/info")
public class ContentInfoController extends BaseController<ContentInfo, Long> {
    @Autowired
    private ContentInfoService contentInfoService;

    @Override
    protected BaseService<ContentInfo, Long> getService() {
        return contentInfoService;
    }

    @Override
    @ApiOperation("添加或更新")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute ContentInfo entity) {
        Result result = Result.createBySuccess();
        //内容是否已存在
        boolean isExist = contentInfoService.isExist(entity);
        if (isExist) {
            result = Result.createByErrorMessage("该类型内容说明已存在");
        } else {
            result = super.saveOrUpdate(entity);
        }
        return result;
    }

}
