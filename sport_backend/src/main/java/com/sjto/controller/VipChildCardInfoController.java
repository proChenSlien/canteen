package com.sjto.controller;

import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.ro.VipChildCardInfoRo;
import com.sjto.dto.vo.VipChildCardInfoVo;
import com.sjto.service.BaseService;
import com.sjto.service.impl.VipChildCardInfoServiceImpl;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName VipChildCardInfoApiController
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:53
 **/
@Api(description = "儿童卡后台请求接口列表")
@RestController
@RequestMapping("/manage/system/vip/child")
public class VipChildCardInfoController extends BaseController<VipChildCardInfo, Long> {

    @Autowired
    private VipChildCardInfoServiceImpl vipChildCardInfoService;

    @ApiOperation("获取所有的儿童会员健身实体卡列表")
    @GetMapping("/query/child/cards")
    public Result<Page<VipChildCardInfoRo>> queryChildCards(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page){

        return vipChildCardInfoService.queryAllVipCardInfoList(page, size);
    }

    @ApiOperation("获取儿童会员健身实体卡信息")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "亲密卡id", required = true)})
    @GetMapping("/card/info")
    public Result<VipChildCardInfoRo> queryCardInfo(@RequestParam Long id){

        return vipChildCardInfoService.queryVipCardInfo(id);
    }

    @ApiOperation("儿童会员健身实体卡到期天数充值")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "days", value = "充值的天数", required = true)})
    @PostMapping("/recharge")
    public Result<VipChildCardInfoRo> recharge(@RequestParam Integer days, Long id){
        return vipChildCardInfoService.recharge(days, id);
    }


    @Override
    protected BaseService<VipChildCardInfo, Long> getService() {
        return vipChildCardInfoService;
    }
}
