package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.ro.VipChildCardInfoRo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.dto.vo.VipChildCardInfoVo;
import com.sjto.service.BaseService;
import com.sjto.service.impl.VipChildCardInfoServiceImpl;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName VipChildCardInfoApiController
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:53
 **/
@RestController
@RequestMapping("/api/system/vip/child")
public class VipChildCardInfoApiController extends BaseController<VipChildCardInfo, Long> {

    @Autowired
    private VipChildCardInfoServiceImpl vipChildCardInfoService;

    @ApiOperation("获取儿童卡列表")
    @GetMapping("/query/list")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true) })
    public Result<List<VipChildCardInfoRo>> queryByUserId(@RequestParam Long userId){
        return vipChildCardInfoService.queryByUserId(userId);
    }

    @ApiOperation("获取会员儿童健身实体卡信息")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "儿童卡id", required = true)})
    @GetMapping("/card/info")
    public Result<VipChildCardInfoRo> queryCardInfo(@RequestParam Long userId, @RequestParam Long id){
        return vipChildCardInfoService.queryVipCardInfo(userId, id);
    }

    @ApiOperation("获取会员儿童健身实体卡认证状态")
    @GetMapping("/auth/state")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "亲密卡id", required = true) })
    public Result<Map> getAuthState(@RequestParam Long id){
        return vipChildCardInfoService.getAuthState(id);
    }

    @ApiOperation("添加宝贝")
    @GetMapping("/add")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "VipChildCardInfoRo", name = "info", value = "儿童信息", required = true)})
    public Result<VipChildCardInfoRo>  add(@RequestParam Long userId, @RequestParam VipChildCardInfoVo info){
        return  vipChildCardInfoService.add(userId, info);
    }

    @Override
    protected BaseService<VipChildCardInfo, Long> getService() {
        return vipChildCardInfoService;
    }
}
