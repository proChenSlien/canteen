package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.enums.AuthState;
import com.sjto.service.BaseService;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.Result;
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
    public Result<Map> getAuthState(@RequestParam Long id){
        return vipSingleGymcardInfoService.getAuthState(id);
    }


    @Override
    @ApiOperation("会员单人健身实体卡新增不可修改")
    @PostMapping("/merge")
    public Result saveOrUpdate(VipSingleGymcardInfo entity) {
        return vipSingleGymcardInfoService.saveOrUpdate(entity);
    }

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }

}
