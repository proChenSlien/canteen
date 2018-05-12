package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.MemberPackages;
import com.sjto.service.BaseService;
import com.sjto.service.MemberPackagesService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 会员充值套餐信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/12 9:35
 */
@RestController
@RequestMapping("/api/member/packages")
public class MemberPackagesApiController extends BaseController<MemberPackages, Long> {
    @Autowired
    private MemberPackagesService memberPackagesService;

    @Override
    protected BaseService<MemberPackages, Long> getService() {
        return memberPackagesService;
    }

    @ApiOperation("产品套餐信息查询（APP）")
    @GetMapping("/getOne/{id}")
    public Result getAdImgInfo(@PathVariable Long id) {
        MemberPackages memberPackages = memberPackagesService.getOne(id);
        return Result.createBySuccess(memberPackages);
    }

}
