package com.sjto.controller;

import com.sjto.domain.MemberPackages;
import com.sjto.service.BaseService;
import com.sjto.service.MemberPackagesService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description: 会员充值套餐信息控制器
 * @Author: fanyongjiu
 * @Date: 18/5/12 15:44
 */
@RestController
@RequestMapping("/manage/member/packages")
public class MemberPackagesController extends BaseController<MemberPackages, Long> {
    @Autowired
    private MemberPackagesService memberPackagesService;

    @Override
    protected BaseService<MemberPackages, Long> getService() {
        return memberPackagesService;
    }

    @Override
    @ApiOperation("添加或更新")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute MemberPackages entity) {
        Result result = Result.createBySuccess();
        //会员充值套餐是否已存在
        boolean isExist = memberPackagesService.isExist(entity);
        if (isExist) {
            result = Result.createByErrorMessage("该会员充值套餐已存在");
        } else {
            //保存
            if (entity.getId() == null) {
                entity.setCreateTime(new Date());
            } else {
                MemberPackages memberPackages = memberPackagesService.findById(entity.getId()).get();
                entity.setCreateTime(memberPackages.getCreateTime());
            }
            entity.setUpdateTime(new Date());
            result = super.saveOrUpdate(entity);
        }
        return result;
    }


}
