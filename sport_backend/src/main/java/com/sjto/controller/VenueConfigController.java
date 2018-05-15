package com.sjto.controller;

import com.sjto.domain.VenueConfigure;
import com.sjto.service.BaseService;
import com.sjto.service.VenueConfigService;
import com.sjto.service.VenuePackService;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:场馆配置
 * @Author: chenpeng
 * @Date: 2018/5/12  16:30
 */
@Api(description = "场馆配置后台请求接口列表")
@RestController
@RequestMapping("/manage/system/venueConfig")
public class VenueConfigController extends BaseController<VenueConfigure, Long>{

    @Autowired
    private VenueConfigService venueConfigService;

    @Override
    protected BaseService<VenueConfigure, Long> getService() {
        return venueConfigService;
    }

    @ApiOperation("添加或更新")
    @ApiImplicitParam(name = "entity", value = "场馆配置信息对象", required = true, dataType = "VenueConfigure")
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute VenueConfigure entity) {
        Result result = Result.createBySuccess("配置成功");
        //判断配置是否重复
        List<VenueConfigure> list = venueConfigService.findVenueConfigure(entity.getKid(), entity.getOid());
        if(list.size() == 0){
            super.saveOrUpdate(entity);
        }else{
            result = Result.createByErrorMessage("请勿重复配置场馆");
        }
        return result;
    }
}
