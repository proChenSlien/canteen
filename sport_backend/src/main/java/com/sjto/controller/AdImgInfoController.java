package com.sjto.controller;

import com.sjto.domain.AdImgInfo;
import com.sjto.service.AdImgInfoService;
import com.sjto.service.BaseService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description: 广告位图片信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/12 13:52
 */
@RestController
@RequestMapping("/manage/adImgInfo")
public class AdImgInfoController extends BaseController<AdImgInfo, Long> {
    @Autowired
    private AdImgInfoService adImgInfoService;

    @Override
    protected BaseService<AdImgInfo, Long> getService() {
        return adImgInfoService;
    }

    @Override
    @ApiOperation("添加或更新")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute AdImgInfo entity) {
        Result result = Result.createBySuccess();
        //广告是否已存在
        boolean isExist = adImgInfoService.isExist(entity);
        if (isExist) {
            result = Result.createByErrorMessage("该类型广告已存在");
        } else {
            //保存
            if (entity.getId() == null) {
                entity.setCreateTime(new Date());
            }else{
                AdImgInfo adImgInfo = adImgInfoService.findById(entity.getId()).get();
                entity.setCreateTime(adImgInfo.getCreateTime());
            }
            entity.setUpdateTime(new Date());
            result = super.saveOrUpdate(entity);
        }
        return result;
    }


}
