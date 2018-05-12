package com.sjto.api;

import com.sjto.controller.BaseController;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.service.BaseService;
import com.sjto.service.impl.VipChildCardInfoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VipChildCardInfoApiController
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:53
 **/
@RestController
@RequestMapping("/api/system/vip/child")
public class VipChildCardInfoApiController extends BaseController<VipChildCardInfo, Long> {

    private VipChildCardInfoServiceImpl vipChildCardInfoService;



    @Override
    protected BaseService<VipChildCardInfo, Long> getService() {
        return vipChildCardInfoService;
    }
}
