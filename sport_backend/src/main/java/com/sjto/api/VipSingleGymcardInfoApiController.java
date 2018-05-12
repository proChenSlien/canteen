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
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "会员单人健身会员卡卡号", required = true) })
    public Result<Map> getAuthState(@RequestParam Long id){
        return vipSingleGymcardInfoService.getAuthState(id);
    }


    @ApiOperation("获取会员单人健身实体卡信息")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true) })
    @GetMapping("/card/info")
    public Result<VipSingleGymcardInfoRo> queryCardInfo(@RequestParam Long userId){
        return vipSingleGymcardInfoService.queryVipCardInfo(userId);
    }


    @ApiOperation("会员单人健身实体卡认证")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "authImgUrl", value = "认证图片地址", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "认证的用户id", required = true)})
    @PostMapping("/auth")
    public Result<VipSingleGymcardInfoRo> auth(String authImgUrl, Long userId) {
        return vipSingleGymcardInfoService.auth(authImgUrl, userId);
    }

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }

}
