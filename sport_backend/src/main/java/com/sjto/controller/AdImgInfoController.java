package com.sjto.controller;

import com.google.common.collect.Maps;
import com.sjto.domain.AdImgInfo;
import com.sjto.service.AdImgInfoService;
import com.sjto.service.BaseService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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
            } else {
                AdImgInfo adImgInfo = adImgInfoService.findById(entity.getId()).get();
                entity.setCreateTime(adImgInfo.getCreateTime());
            }
            entity.setUpdateTime(new Date());
            result = super.saveOrUpdate(entity);
        }
        return result;
    }

    @Override
    @ApiOperation("使用记录查询（APP）")
    @GetMapping(value = "/list")
    public Result<Map> list(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page, @ModelAttribute AdImgInfo entity) {
        Page<AdImgInfo> current = adImgInfoService.getAll(page, size, entity);
        Map map = Maps.newHashMap();
        map.put("page", current);
        return Result.createBySuccess(map);
    }
}
