package com.sjto.controller;

import com.sjto.domain.VenueConfigure;
import com.sjto.service.BaseService;
import com.sjto.service.VenueConfigService;
import com.sjto.service.VenuePackService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute VenueConfigure entity) {
        Result result = Result.createBySuccess();
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
