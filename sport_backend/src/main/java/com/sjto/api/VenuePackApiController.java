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
import java.util.Map;


@RestController
@RequestMapping("/api/venue/venuePackages")
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
        //先判断是否有配置多个场馆
        List<Map<String, Object>> current;

        List<VenuePackages> list = venuePackService.queryListConfigure();
        if(list.size() == 0){//没有配置多个场馆就查询出一个主场馆
            current = venuePackService.queryVenuePackMain();
        }else{
            current = venuePackService.queryVenuePackList();
        }
        return Result.createBySuccess(current);
    }

//    @ApiOperation("次票列表查询(一个主场馆)")
//    @PostMapping("/venuePackMain")
//    public Result queryVenuePackMain(){
//
//        List<VenuePackages> current = venuePackService.queryVenuePackMain();
//        return Result.createBySuccess(current);
//    }
}
