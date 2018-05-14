package com.sjto.controller;

import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.service.BaseService;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VipSingleGymcardInfoController
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:39
 **/

@Api(description = "成人卡后台请求接口列表")
@RestController
@RequestMapping("/manage/system/vip/single")
public class VipSingleGymcardInfoController extends BaseController<VipSingleGymcardInfo, Long>  {

    @Autowired
    private VipSingleGymcardInfoService vipSingleGymcardInfoService;


    @ApiOperation("照片审核")
    @GetMapping("/card/verify")
    public Result<VipSingleGymcardInfoRo> verify(Long id, Integer authState){
        return vipSingleGymcardInfoService.verify(id,authState);
    }

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }
}
