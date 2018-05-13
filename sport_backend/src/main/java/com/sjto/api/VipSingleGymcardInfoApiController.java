package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.enums.AuthState;
import com.sjto.service.BaseService;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName VipSingleGymcardInfoApiController
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:39
 **/
@RestController
@RequestMapping("/api/system/vip/single")
public class VipSingleGymcardInfoApiController extends BaseController<VipSingleGymcardInfo, Long> {

    @Autowired
    private VipSingleGymcardInfoService vipSingleGymcardInfoService;


    @ApiOperation("获取认证状态")
    @GetMapping("/auth/state")
    public Result<Map> getAuthState(){
        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/
        Long userId = 123L;
        return vipSingleGymcardInfoService.getAuthState(userId);
    }


    @ApiOperation("获取会员单人健身实体卡信息")
    @GetMapping("/card/info")
    public Result<VipSingleGymcardInfoRo> queryCardInfo(){

        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        Long userId = 123L;
        Long phone = 13888888888L;
        String loginName = "administrator";
        return vipSingleGymcardInfoService.queryVipCardInfo(userId, loginName, phone);
    }

    @ApiOperation("单人会员健身实体卡认证")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "authImgUrl", value = "认证图片地址", required = true)})
    @PostMapping("/auth")
    public Result<VipSingleGymcardInfoRo> auth(String authImgUrl) {

        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        Long userId = 123L;

        return vipSingleGymcardInfoService.auth(authImgUrl, userId);
    }

    @ApiOperation("单人会员健身实体卡到期天数充值及天数兑换")
    @ApiImplicitParams({ @ApiImplicitParam(dataType = "Long", name = "days", value = "充值的天数")})
    @PostMapping("/recharge")
    public Result<VipSingleGymcardInfoRo> recharge(@RequestParam Integer days){
        //用户是否登录
        /*RemoteUser user = getCurrentUser();
        if (user == null) {
            return  Result.createByErrorCodeMessage(ResultCode.NEED_LOGIN.getCode(), ResultCode.NEED_LOGIN.getDesc());
        }*/

        Long userId = 123L;
        return vipSingleGymcardInfoService.recharge(days, userId);
    }

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }

}
