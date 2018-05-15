package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.ConversionRecord;
import com.sjto.service.BaseService;
import com.sjto.service.ConversionRecordService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Description: 兑换信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/12 11:07
 */
@Api(description = "兑换信息")
@RestController
@RequestMapping("/api/conversion/record")
public class ConversionRecordApiController extends BaseController<ConversionRecord, Long> {
    @Autowired
    private ConversionRecordService conversionRecordService;

    @Override
    protected BaseService<ConversionRecord, Long> getService() {
        return conversionRecordService;
    }

    @ApiOperation("兑换信息保存（APP）")
    @PostMapping(value = "/save")
    public Result save(@RequestBody ConversionRecord entity) {
        Result result = Result.createBySuccess();
        //用户是否登录
//        RemoteUser user = getCurrentUser();
//        if (user == null) {
//            result = Result.error().setCode("401").setMsg("用户未登录");
//            return result;
//        }

        Long userId = 1L;
        String userName = "admin";
//        //校验兑换的礼品卡
//        Long sid = entity.getSid();
//
//        //校验健身实体卡
//        Long pid = entity.getPid();

        entity.setCreateTime(new Date());
        entity.setUserId(userId);
        entity.setUserName(userName);
        conversionRecordService.save(entity);
        return result;
    }
}
