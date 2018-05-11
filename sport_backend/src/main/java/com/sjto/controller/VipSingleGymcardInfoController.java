package com.sjto.controller;

import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.service.BaseService;
import com.sjto.service.VipSingleGymcardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VipSingleGymcardInfoController
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:39
 **/

@RestController
@RequestMapping("/manage/system/vip/single")
public class VipSingleGymcardInfoController extends BaseController<VipSingleGymcardInfo, Long>  {

    @Autowired
    private VipSingleGymcardInfoService vipSingleGymcardInfoService;

    @Override
    protected BaseService<VipSingleGymcardInfo, Long> getService() {
        return vipSingleGymcardInfoService;
    }
}
