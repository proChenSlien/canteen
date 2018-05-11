package com.sjto.controller;

import com.sjto.domain.VenueConfigure;
import com.sjto.service.BaseService;
import com.sjto.service.VenueConfigService;
import com.sjto.service.VenuePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/system/venueConfig")
public class VenueConfigController extends BaseController<VenueConfigure, Long>{

    @Autowired
    private VenueConfigService venueConfigService;

    @Override
    protected BaseService<VenueConfigure, Long> getService() {
        return venueConfigService;
    }
}
