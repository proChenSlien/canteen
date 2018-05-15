package com.sjto.api;

import com.sjto.controller.BaseController;
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
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VipChildCardInfoApiController
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:53
 **/
@Api(description = "儿童卡前台请求接口列表")
@RestController
@RequestMapping("/api/system/vip/child")
public class VipChildCardInfoApiController extends BaseController<VipChildCardInfo, Long> {

    @Autowired
    private VipChildCardInfoServiceImpl vipChildCardInfoService;

    @ApiOperation("获取用户的儿童会员健身实体卡列表")
    @GetMapping("/query/list")
    public Result<List<VipChildCardInfoRo>> queryChildCards(){
        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        Long userId = 123L;
        return vipChildCardInfoService.queryByUserId(userId);
    }

    @ApiOperation("获取儿童会员健身实体卡信息")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "亲密卡id", required = true)})
    @GetMapping("/query/one/{id}")
    public Result<VipChildCardInfoRo> queryCardInfo(@PathVariable Long id) {
        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        return vipChildCardInfoService.queryOne(id);
    }

    @ApiOperation("获取儿童会员健身实体卡认证状态")
    @GetMapping("/auth/state/{id}")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "亲密卡id", required = true) })
    public Result<Map> getAuthState(@PathVariable Long id){
        return vipChildCardInfoService.getAuthState(id);
    }

    @ApiOperation("添加宝贝")
    @PostMapping("/add")
    public Result<VipChildCardInfoRo>  add(@RequestBody VipChildCardInfoVo vipChildCardInfoVo){

        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        Long userId = 123L;
        return  vipChildCardInfoService.add(userId, vipChildCardInfoVo);
    }

    @ApiOperation("儿童会员健身实体卡到期天数充值")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "days", value = "充值的天数", required = true)})
    @PostMapping("/recharge/{id}")
    public Result<VipChildCardInfoRo> recharge(@RequestParam Integer days,@PathVariable Long id){
        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        Long userId = 123L;
        return vipChildCardInfoService.recharge(days, id);
    }

    @ApiOperation("儿童会员健身实体卡认证")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "authImgUrl", value = "认证图片地址", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "authImgUrl", value = "认证会员卡id", required = true)})
    @PostMapping("/auth/{id}")
    public Result<VipChildCardInfoRo> auth(String authImgUrl, @PathVariable Long id) {

        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        Long userId = 123L;

        return vipChildCardInfoService.auth(authImgUrl, id);
    }

    @Override
    protected BaseService<VipChildCardInfo, Long> getService() {
        return vipChildCardInfoService;
    }
}
