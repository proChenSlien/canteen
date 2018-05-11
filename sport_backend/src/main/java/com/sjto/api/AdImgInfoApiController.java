package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.AdImgInfo;
import com.sjto.service.AdImgInfoService;
import com.sjto.service.BaseService;
import com.sjto.utils.CommonUtil;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 广告位图片信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/11 16:13
 */
@RestController
@RequestMapping("/api/adImgInfo")
public class AdImgInfoApiController extends BaseController<AdImgInfo, Long> {
    @Autowired
    private AdImgInfoService adImgInfoService;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    protected BaseService<AdImgInfo, Long> getService() {
        return adImgInfoService;
    }

    @ApiOperation("活动广告列表查询（APP）")
    @GetMapping("/getList")
    public Result getList() {
        List<Map<String, Object>> list = adImgInfoService.getList();
        if (list == null) {
            return Result.createByErrorMessage("暂无数据");
        }
        return Result.createBySuccess(list);
    }

    @ApiOperation("活动广告详情查询（APP）")
    @GetMapping("/getOne/{id}")
    public Result getAdImgInfo(@PathVariable Long id) {
        Map<String, Object> map = adImgInfoService.getImgInfo(id);
        if (map == null) {
            return Result.createByErrorMessage("广告不存在");
        }
        return Result.createBySuccess(map);
    }

}
