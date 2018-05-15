package com.sjto.controller;

import com.sjto.domain.VenuePackages;
import com.sjto.service.BaseService;
import com.sjto.service.VenuePackService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:次票
 * @Author: chenpeng
 * @Date: 2018/5/11  10:30
 */
@Api(description = "次票后台请求接口列表")
@RestController
@RequestMapping("/manager/system/venuePackages")
public class VenuePackController extends BaseController<VenuePackages, Long>{

    @Autowired
    private VenuePackService venuePackService;

    @Override
    protected BaseService<VenuePackages, Long> getService() {
        return venuePackService;
    }


}
