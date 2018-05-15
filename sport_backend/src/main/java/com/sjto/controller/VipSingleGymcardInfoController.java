package com.sjto.controller;

import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.service.BaseService;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName VipSingleGymcardInfoController
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:39
 **/

@Api(description = "成人卡后台请求接口列表")
@RestController
@RequestMapping("/manage/system/vip/adult")
public class VipSingleGymcardInfoController extends BaseController<VipSingleGymcardInfo, Long>  {

    @Autowired
    private VipSingleGymcardInfoService vipSingleGymcardInfoService;


    @ApiOperation("获取所有的成人会员健身实体卡列表")
    @GetMapping("/query/list")
    public Result<Map> queryAdultCards(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page, @ModelAttribute VipSingleGymcardInfo entity){

        return vipSingleGymcardInfoService.queryAllVipCardInfoList(page, size, entity);
    }

    @ApiOperation("获取成人会员健身实体卡信息")
    @GetMapping("query/one/{id}")
    public Result<VipSingleGymcardInfoRo> queryCardInfo(@PathVariable Long id) {
        return vipSingleGymcardInfoService.queryOne(id);
    }

    @ApiOperation("照片审核")
    @PostMapping("/verify/{id}")
    public Result<VipSingleGymcardInfoRo> verify(@PathVariable Long id, Integer authState){
        return vipSingleGymcardInfoService.verify(id,authState);
    }

    @ApiOperation("单人会员健身实体卡到期天数充值")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "days", value = "充值的天数"),
            @ApiImplicitParam(dataType = "Long", name = "userId", value = "用户id")})
    @PostMapping("/recharge")
    public Result<VipSingleGymcardInfoRo> recharge(@RequestParam Integer days, @RequestParam Long userId){

        return vipSingleGymcardInfoService.recharge(days, userId);
    }

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }
}
