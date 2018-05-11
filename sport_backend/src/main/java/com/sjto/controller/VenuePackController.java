package com.sjto.controller;

import com.sjto.domain.VenuePackages;
import com.sjto.service.BaseService;
import com.sjto.service.VenuePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
