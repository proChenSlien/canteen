package com.sjto.controller;

import com.sjto.controller.BaseController;
import com.sjto.domain.VenueInfo;
import com.sjto.service.BaseService;
import com.sjto.service.VenueInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/venue/venueInfo")
public class VenueInfoController extends BaseController<VenueInfo, Long> {

    @Autowired
    private VenueInfoService venueInfoService;

    @Override
    protected BaseService<VenueInfo, Long> getService() {
        return venueInfoService;
    }
}
