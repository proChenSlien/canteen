package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.VenuePackages;
import com.sjto.service.BaseService;
import com.sjto.service.VenuePackService;
import com.sjto.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/system/venuePackages")
public class VenuePackApiController extends BaseController<VenuePackages, Long> {

    @Autowired
    private VenuePackService venuePackService;


    @Override
    protected BaseService<VenuePackages, Long> getService() {
        return venuePackService;
    }


    @ApiOperation("次票列表查询（后期可能会对次票配置多个场馆）")
    @PostMapping("/venuePackList")
    public Result queryVenuePackList(){

        List<VenuePackages> current = venuePackService.queryVenuePackList();
        return Result.createBySuccess(current);
    }

    @ApiOperation("次票列表查询(一个主场馆)")
    @PostMapping("/venuePackMain")
    public Result queryVenuePackMain(){

        List<VenuePackages> current = venuePackService.queryVenuePackMain();
        return Result.createBySuccess(current);
    }
}
