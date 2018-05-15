package com.sjto.controller;

import com.sjto.controller.BaseController;
import com.sjto.domain.VenueInfo;
import com.sjto.service.BaseService;
import com.sjto.service.VenueInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:场馆信息
 * @Author: chenpeng
 * @Date: 2018/5/12  13:30
 */
@Api(description = "场馆信息后台请求接口列表")
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
